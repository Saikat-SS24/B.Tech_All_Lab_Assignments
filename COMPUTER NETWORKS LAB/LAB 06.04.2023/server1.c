#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <sys/un.h>

unsigned int crc_calculation(char data[], char divisor[])
{
    int data_length = strlen(data);
    int divisor_length = strlen(divisor);
    unsigned int remainder = 0;

    for (int i = 0; i < data_length; i++)
    {
        if (remainder & (1 << (divisor_length - 1)))
        {
            remainder = (remainder << 1) ^ strtol(divisor, NULL, 2);
        }
        else
        {
            remainder = (remainder << 1);
        }
        remainder ^= (data[i] - '0');
    }

    return remainder;
}

int main()
{
    int sockfd, newsockfd;
    socklen_t clilen;
    char buffer[256];
    struct sockaddr_un serv_addr, cli_addr;
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
    if (bind(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0)
    {
        perror("ERROR on binding");
        exit(1);
    }

    listen(sockfd, 5);
    clilen = sizeof(cli_addr);

    newsockfd = accept(sockfd, (struct sockaddr *)&cli_addr, &clilen);
    if (newsockfd < 0)
    {
        perror("ERROR on accept");
        exit(1);
    }

    bzero(buffer, 256);
    n = read(newsockfd, buffer, 255);
    if (n < 0)
    {
        perror("ERROR reading from socket");
        exit(1);
    }
    printf("Data Word: %s\n", buffer);
    char data[256];
    strcpy(data, buffer);

    bzero(buffer, 256);
    n = read(newsockfd, buffer, 255);
    if (n < 0)
    {
        perror("ERROR reading from socket");
        exit(1);
    }
    printf("Divisor: %s\n", buffer);
    char divisor[256];
    strcpy(divisor, buffer);

    unsigned int code_word = crc_calculation(data, divisor);
    printf("Code Word: %u\n", code_word);

    bzero(buffer, 256);
    sprintf(buffer, "%u", code_word);
    n = write(newsockfd, buffer, strlen(buffer));
    if (n < 0)
    {
        perror("ERROR writing to socket");
        exit(1);
    }

    close(newsockfd);
    close(sockfd);
    unlink("server_socket");

    return 0;
}