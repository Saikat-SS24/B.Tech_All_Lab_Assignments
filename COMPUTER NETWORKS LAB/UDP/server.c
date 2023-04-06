#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
 
#define MAXSTACK 100
#define POSTFIXSIZE 100
int stack[MAXSTACK];
int top = -1;
void push(int item)
{

    if (top >= MAXSTACK - 1) {
        printf("stack over flow");
        return;
    }
    else {
        top = top + 1;
        stack[top] = item;
    }
}

int pop()
{
    int item;
    if (top < 0) {
        printf("stack under flow");
    }
    else {
        item = stack[top];
        top = top - 1;
        return item;
    }
}

void evaluate_postfix(char postfix[])
{
    int i;
    char ch;
    int val;
    int A, B;

    for (i = 0; postfix[i] != '$'; i++) {
        ch = postfix[i];
        if (isdigit(ch)) {
            push(ch - '0');
        }
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            A = pop();
            B = pop();
            switch (ch)
            {
                case '*':
                    val = B * A;
                    break;
                case '/':
                    val = B / A;
                    break;
                case '+':
                    val = B + A;
                    break;
                case '-':
                    val = B - A;
                    break;
            }
            push(val);
        }
    }
    printf(" \n Result: %d \n", pop());
}

int main(void) {
    int received_data_length;
    int sent_data_length;
    int client_address_length;
    int server_port = 5000;
    short sock_file_descriptor;
    char server_ip[] = "127.0.0.1";
    char buffer[256];
    char *client;
    struct sockaddr_in server_address;
    struct sockaddr_in client_address;
 
    fflush(stdin);
    client = (char *) malloc(sizeof(server_address));
 
    sock_file_descriptor = socket(PF_INET, SOCK_DGRAM, 0);
    if (sock_file_descriptor < 0) {
        printf("failed");
        exit(1);
    } else {
        printf("socket created");
    }
 
    bzero(&server_address, sizeof(server_address));
    server_address.sin_family = PF_INET;
    inet_aton(server_ip, &server_address.sin_addr);
    server_address.sin_port = htons(server_port);
 
    bind(sock_file_descriptor, (struct sockaddr *) &server_address, sizeof(server_address));
 
    received_data_length = recvfrom(sock_file_descriptor, buffer, strlen(buffer), 0, (struct sockaddr *) &client_address, &client_address_length);
    fflush(stdout);
    evaluate_postfix(buffer);
    if (received_data_length != -1)
        printf("\n* receive success *\n");
    else
        printf("\n* receive failure *\n");
 
    sent_data_length = sendto(sock_file_descriptor, buffer, received_data_length, 0, (struct sockaddr *) &client_address, sizeof(client_address));
    if (sent_data_length != -1)
        printf("\n* send success *\n");
    else
        printf("\n* send failure *\n");
 
    close(sock_file_descriptor);
    return 0;
}
