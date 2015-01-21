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
  fputs(strerror(errno), stderr);
  fputs(": ", stderr);
  fputs(message, stderr);
  fputc('\n', stderr);
  exit(1);
}

int main(int argc,char **argv) {
  char *IPServeur=NULL, nom[512], message[512], ipClient[INET_ADDRSTRLEN];
  int portServeur, socketServeur, longueur, nbOctets;
  struct sockaddr_in adresseServeur, adresseClient;

  // Récupération des paramètres
  if ( argc>=3 ) {
    IPServeur = argv[1];
    portServeur = atoi(argv[2]);
  }else if( argc>=2 ){
    IPServeur = "127.0.0.1";
  }else {
    IPServeur = "127.0.0.1";
    portServeur = 1024;    
  }

  // Construction de l'adresse
  memset(&adresseServeur, 0, sizeof(adresseServeur));
  adresseServeur.sin_family = AF_INET;
  adresseServeur.sin_port = htons(portServeur);
  inet_pton(AF_INET, IPServeur, &(adresseServeur.sin_addr));
  if(adresseServeur.sin_addr.s_addr==INADDR_NONE)
    erreur("mauvaise addresse");

  // Création du Socket
  socketServeur = socket(PF_INET, SOCK_DGRAM, IPPROTO_UDP);
  if( socketServeur==-1 )
    erreur("socket");

  // Bind
  if( bind(socketServeur, (struct sockaddr *)&adresseServeur, sizeof(adresseServeur))==-1 )
      erreur("bind()");

  // Ecouter le Socket et traiter les requêtes
  strcpy(nom, "START");
  while( !(strcasecmp(nom,"QUIT")==0) ) {
    longueur = sizeof(adresseClient);
    nbOctets = recvfrom(socketServeur, nom, sizeof(nom), 0, (struct sockaddr *)&adresseClient, &longueur);
    if(nbOctets==-1) {
      erreur("rcvfrom()");
    }else {
      nom[nbOctets]=0;
      inet_ntop(AF_INET, &(adresseClient.sin_addr), ipClient, INET_ADDRSTRLEN);
      printf("(%s:%u) : '%s'\n", ipClient, (unsigned)ntohs(adresseClient.sin_port), nom);
      if( !(strcasecmp(nom,"QUIT")==0) ) {
	strcpy(message, "Hello ");
	strcat(message, nom);
      }else
	strcpy(message, "Au revoir !");	
      if( sendto(socketServeur, message, strlen(message), 0, (struct sockaddr *)&adresseClient, longueur)==-1 )
	erreur("sendto()");
    }
  }
  close(socketServeur);
  return 1;
}
