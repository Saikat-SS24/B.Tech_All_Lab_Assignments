#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <ctype.h> 

void error(const char *msg) {
    perror(msg);
    exit(0);
}
 
int main(int argc, char *argv[]) {
    int sock_file_descriptor;
    int server_sock_port_no;
    int data_length;
    struct sockaddr_in server_address;
    struct hostent *server;
    char buff[256];
 
    if (argc < 3) {
        fprintf(stderr, "Usage: %s hostname port\n", argv[0]);
        exit(0);
    }
 
    server_sock_port_no = atoi(argv[2]);
 
    sock_file_descriptor = socket(AF_INET, SOCK_STREAM, 0);
    if (sock_file_descriptor < 0)
        error("Error opening socket");
 
    server = gethostbyname(argv[1]);
    if (server == NULL)
        error("Error, no such host\n");
 
    bzero((char *) &server_address, sizeof(server_address));
 
    server_address.sin_family = AF_INET;
    bcopy((char *) server->h_addr, (char *)&server_address.sin_addr.s_addr, server->h_length);
    server_address.sin_port = htons(server_sock_port_no);
 
    if (connect(sock_file_descriptor, (struct sockaddr *) &server_address, sizeof(server_address)) < 0)
        error("Error in connecting...");
 
    printf("Enter the postfix expression terminated by ')'\n");
    /* reset the buffer */
    bzero(buff, 256);
 
    /* read the data from standard input */
    fgets(buff, 255, stdin);
 
    /* send the content of buffer to server */
    data_length = write(sock_file_descriptor, buff, strlen(buff));
    if (data_length < 0)
        error("Error in writing");
 
    /* reset the buffer */
    bzero(buff, 256);
    /* read the content received from server */
    data_length = read(sock_file_descriptor, buff, 255);
    if (data_length < 0)
        error("Error in reading");
    printf("Expression sent\n");
 
    close(sock_file_descriptor);
    return 0;
}