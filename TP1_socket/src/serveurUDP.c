
#include <sys/socket.h>
#include <netinet/in.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char**argv)
{
    int sockfd,n;
    struct sockaddr_in servaddr,cliaddr;
    socklen_t len;
    char mesg[1000];
    
    sockfd=socket(AF_INET,SOCK_DGRAM,0);
    
    bzero(&servaddr,sizeof(servaddr));
    servaddr.sin_family = AF_INET;
    servaddr.sin_addr.s_addr=htonl(INADDR_ANY);
    servaddr.sin_port=htons(2000);
    bind(sockfd,(struct sockaddr *)&servaddr,sizeof(servaddr));
    
    for (;;)
    {
        len = sizeof(cliaddr);
        n = recvfrom(sockfd,mesg,1000,0,(struct sockaddr *)&cliaddr,&len);
        printf("-------------------------------------------------------\n");
        mesg[n] = 0;
        char message[100];
        strcpy(message,mesg);
        printf("Calcul:\n");
        char *pch = strtok (mesg,"+-");
        int a = atoi(pch);
        pch = strtok (NULL, "+-");
        int b = atoi(pch);
        char res[100];
        printf("%s",message);
        if(strstr(message,"+") != NULL)
        {
            sprintf(res,"%d\n",a+b);
        }
        else if(strstr(message,"-") != NULL)
        {
            sprintf(res,"%d\n",a-b);
        }
        else
        {
            sprintf(res,"%s","Une erreur s'est produite\n\r");
        }
        printf("resultat: %s",res);
        sendto(sockfd,res,sizeof(res),0,(struct sockaddr *)&cliaddr,sizeof(cliaddr));
        memset(message, 0, sizeof(message));
        memset(mesg, 0, sizeof(mesg));
        memset(res, 0, sizeof(res));
        printf("-------------------------------------------------------\n");
    }
}