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
  int s, sb, envoye, recu, l;
  struct sockaddr_in adr_serveur, adr_client, adr; 
  char nom[512], message[512], ip[INET_ADDRSTRLEN];        

  // Création de l'adresse  
  adr_serveur.sin_family = AF_INET;
  inet_pton(AF_INET, argv[1], &(adr_serveur.sin_addr)); // 1er argument : IP du serveur
  adr_serveur.sin_port = htons(atoi(argv[2]));          // 2nd argument : port du serveur
  if(adr_serveur.sin_addr.s_addr==INADDR_NONE)
    erreur("mauvaise addresse");

  // Création du Socket
  s = socket(PF_INET, SOCK_DGRAM, IPPROTO_UDP);
  if ( s == -1 )
    erreur("socket()");

  // Envoi de la requête
  strcpy(nom, argv[3]);                                 // 3eme argument : nom
  envoye = sendto(s, nom, strlen(nom), 0 , (struct sockaddr *)&adr_serveur, sizeof(adr_serveur)); 
  if( envoye < 0 )
    erreur("sendto()");

  // Récupération de la réponse
  l = sizeof(adr);
  recu = recvfrom(s, message, sizeof(message), 0, (struct sockaddr *)&adr, &l); 
  if( recu < 0 )
    erreur("recvfrom()");
  message[recu] = 0;
  inet_ntop(AF_INET, &(adr.sin_addr), ip, INET_ADDRSTRLEN);
  printf("(%s:%u) : '%s'\n", ip,(unsigned)ntohs(adr.sin_port), message);
  close(s);
  putchar('\n');
  return 0;
}
