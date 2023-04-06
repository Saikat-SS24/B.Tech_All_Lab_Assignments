#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <netinet/in.h>
 
void error(const char *msg) {
    perror(msg);
    exit(1);
}
 
int main(int argc, char *argv[]) {
    int sock_file_descriptor;                           // socket file descriptor
    int client_sock_file_descriptor;                // client socket file descriptor
    int server_sock_port_no;            // port number
    socklen_t client_socket_length;     // client socket length
    char buff[256];                     // buffer
    struct sockaddr_in server_address;  // address of this server
    struct sockaddr_in client_address;  // address of a client
    int max_queue_len_4_pending_conn = 5;   // maximum length for the queue of pending connections
    int data_length;
 
    if (argc < 2)
        error("Error!\n This program requires port number as command line argument.");
 
    sock_file_descriptor = socket(AF_INET, SOCK_STREAM, 0);
    if (sock_file_descriptor < 0)
        error("Unable to open socket.....");
 
    /* set all the bits of server_address by 0 (zero) */
    bzero((char *) &server_address, sizeof(server_address));
 
    /* convert the string to integer and set the value to vaiable server_sock_port_no */
    server_sock_port_no = atoi(argv[1]);
 
    /* prepare server_address variable */
    server_address.sin_family = AF_INET;
    server_address.sin_addr.s_addr = INADDR_ANY;
    server_address.sin_port = htons(server_sock_port_no);
 
    /* bind function returns negative number if there is any error */
    if (bind(sock_file_descriptor, (struct sockaddr *) &server_address, sizeof(server_address)) < 0)
        error("Error in Binding");
 
    /* this function returns 0 on success and -1 on failure */
    listen(sock_file_descriptor, max_queue_len_4_pending_conn);
 
    client_socket_length = sizeof(client_address);
 
    /* accept function is used to accept a connection request on the server socket socket.
     * The return value of accept is the file descriptor for the new socket.
     * After accept, the original socket socket remains open and unconnected,
     * and continues listening until you close it. */
    client_sock_file_descriptor = accept(sock_file_descriptor, (struct sockaddr *) &client_address, &client_socket_length);
 
    if (client_sock_file_descriptor < 0)
        error("Unable to accept");
 
    /* reset the buffer */
    bzero(buff, 256);
 
    /* read the data sent by client */
    data_length = read(client_sock_file_descriptor, buff, sizeof(buff));
    if (data_length < 0)
        error("Error in reading data");
    printf("Here is the message: %s\n", buff);
 
    /* write the data for the client */
    data_length = write(client_sock_file_descriptor, buff, sizeof(buff));
    if (data_length < 0)
        error("Error in writing data");
 
    close(client_sock_file_descriptor);
    close(sock_file_descriptor);
    return 0;
}
