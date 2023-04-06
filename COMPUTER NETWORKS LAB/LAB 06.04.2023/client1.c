#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <sys/un.h>

int main()
{
    int sockfd;
    struct sockaddr_un serv_addr;
    char buffer[256];
    int n;

    sockfd = socket(AF_UNIX, SOCK_STREAM, 0);
    if (sockfd < 0)
    {
        perror("ERROR opening socket");
        exit(1);
    }

    bzero((char *)&serv_addr, sizeof(serv_addr));
    serv_addr.sun_family = AF_UNIX;
    strcpy(serv_addr.sun_path, "server_socket");
    if (connect(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0)
    {
        perror("ERROR connecting");
        exit(1);
    }

    printf("Enter Data Word: ");
    bzero(buffer, 256);
    fgets(buffer, 255, stdin);
    buffer[strcspn(buffer, "\n")] = '\0';

    n = write(sockfd, buffer, strlen(buffer));
    if (n < 0)
    {
        perror("ERROR writing to socket");
        exit(1);
    }

    printf("Enter Divisor: ");
    bzero(buffer, 256);
    fgets(buffer, 255, stdin);
    buffer[strcspn(buffer, "\n")] = '\0';

    n = write(sockfd, buffer, strlen(buffer));
    if (n < 0)
    {
        perror("ERROR writing to socket");
        exit(1);
    }

    bzero(buffer, 256);
    n = read(sockfd, buffer, 255);
    if (n < 0)
    {
        perror("ERROR reading from socket");
        exit(1);
    }

    printf("CRC Code Word: %s\n", buffer);

    close(sockfd);

    return 0;
}
