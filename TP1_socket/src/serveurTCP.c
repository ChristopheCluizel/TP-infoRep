
#include <sys/socket.h>
#include <netinet/in.h>
#include <stdio.h>

int main(int argc, char**argv)
{
   int listenfd,connfd,n;
   struct sockaddr_in servaddr,cliaddr;
   socklen_t clilen;
   pid_t     childpid;
   char mesg[1000];

   listenfd=socket(AF_INET,SOCK_STREAM,0);

   bzero(&servaddr,sizeof(servaddr));
   servaddr.sin_family = AF_INET;
   servaddr.sin_addr.s_addr=htonl(INADDR_ANY);
   servaddr.sin_port=htons(2000);
   bind(listenfd,(struct sockaddr *)&servaddr,sizeof(servaddr));

   listen(listenfd,1024);

   for(;;)
   {
      clilen=sizeof(cliaddr);
      connfd = accept(listenfd,(struct sockaddr *)&cliaddr,&clilen);

      if ((childpid = fork()) == 0)
      {
         close (listenfd);

         for(;;)
         {
            n = recvfrom(connfd,mesg,1000,0,(struct sockaddr *)&cliaddr,&clilen);
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
                sprintf(res,"%d",a+b);
            }
            else if(strstr(message,"-") != NULL)
            {
                sprintf(res,"%d",a-b);
            }
            else
            {
                strcpy(res,"Une erreur s'est produite");
            }
            printf("resultat: %s",res);
            sendto(connfd,res,sizeof(res),0,(struct sockaddr *)&cliaddr,sizeof(cliaddr));
            memset(message, 0, sizeof(message));
            memset(mesg, 0, sizeof(mesg));
            memset(res, 0, sizeof(res));
            printf("-------------------------------------------------------\n");
         }
         
      }
      close(connfd);
   }
}