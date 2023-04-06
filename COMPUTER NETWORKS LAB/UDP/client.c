#include <string.h>
#include <sys/types.h>
#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
 
int main(void) {
    int sock_file_descriptor;
    int sent_data_length;
    int received_data_length;
 
    unsigned int server_address_len;
    unsigned short server_port = 5000;
    char server_ip[] = "127.0.0.1";
    char text[] = "Hello";
    char buffer[256];
    struct sockaddr_in server_address;
 
    server_address_len = sizeof(server_address);
    bzero(&server_address, sizeof(server_address));
    server_address.sin_family = PF_INET;
    server_address.sin_port = htons(server_port);
 
    inet_aton(server_ip, &server_address.sin_addr);
 
    sock_file_descriptor = socket(PF_INET, SOCK_DGRAM, 0);
 
    /* send text to server */
    sent_data_length = sendto(sock_file_descriptor, text, strlen(text), 0, (struct sockaddr *) &server_address, sizeof(server_address));
    if (sent_data_length != -1)
        printf("\n* message sent successfully *\n");
    else
        printf("\n* message sent failure *\n");
 
    /* receive data from server */
    received_data_length = recvfrom(sock_file_descriptor, buffer, strlen(buffer), 0, (struct sockaddr *) &server_address, &server_address_len);
    if (received_data_length != -1) {
        buffer[received_data_length] = '\0';
        printf("\n* %s *\n", buffer);
    }
 
    close(sock_file_descriptor);
    return 0;
}
