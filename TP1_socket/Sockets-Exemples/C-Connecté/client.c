#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <time.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

static void erreur(const char *message) {
  fputs(strerror(errno),stderr);
  fputs(": ", stderr);
  fputs(message, stderr);
  fputc('\n', stderr);
  exit(1);
}

int main(int argc,char **argv) {
  int socketClient, socketServeur, recu;
  struct sockaddr_in adr_serveur, adr_client, adr; 
  char nom[512], message[512], ip[INET_ADDRSTRLEN];        

  // Création de l'adresse
  adr_serveur.sin_family = AF_INET;
  inet_pton(AF_INET, argv[1], &(adr_serveur.sin_addr)); // 1er argument : IP du serveur
  adr_serveur.sin_port = htons(atoi(argv[2]));          // 2nd argument : port du serveur
  if(adr_serveur.sin_addr.s_addr==INADDR_NONE)
    erreur("mauvaise addresse");

  // Création de la Socket
  socketClient = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP);
  if ( socketClient == -1 )
    erreur("socket()");

  // Connection
  socketServeur = connect(socketClient, (struct sockaddr *)&adr_serveur, sizeof(adr_serveur));
  if( socketServeur==-1 )
    erreur("connect()");

  // Envoi de la requête
  strcpy(nom, argv[3]);                                 // 3eme argument : nom
  if( write(socketServeur, nom, strlen(nom))==-1 )
    erreur("write()");

  recu = read(socketServeur, &message, sizeof(message)-1); 
  if( recu==-1 )
    erreur("read()");
  message[recu] = '\0';

  inet_ntop(AF_INET, &(adr.sin_addr), ip, INET_ADDRSTRLEN);
  printf("(%s:%u) : '%s'\n", ip,(unsigned)ntohs(adr.sin_port), message);
  close(socketServeur);
  close(socketClient);
  putchar('\n');
  return 0;
}
