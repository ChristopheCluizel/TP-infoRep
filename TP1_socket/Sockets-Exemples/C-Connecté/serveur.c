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
  int portServeur, socketServeur, longueur, socketClient, recu;
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
  socketServeur = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP);
  if( socketServeur==-1 )
    erreur("socket");

  // Bind
  if( bind(socketServeur, (struct sockaddr *)&adresseServeur, sizeof(adresseServeur))==-1 )
      erreur("bind()");

  // Ecouter le Socket
  if( listen(socketServeur, 10)==-1)
    erreur("listen()");

  // Traiter les requêtes
  strcpy(nom, "START");
  while( !(strcasecmp(nom,"QUIT")==0) ) {
    longueur = sizeof(adresseClient);
    socketClient = accept(socketServeur, (struct sockaddr *)&adresseClient, &longueur);
    if(socketClient==-1) {
      erreur("accept()");
    }else {
      recu = read(socketClient, &nom, sizeof(nom)-1);
      printf("%d\n",recu);
      if( recu==-1)
	erreur("read()");
      nom[recu]='\0';
      inet_ntop(AF_INET, &(adresseClient.sin_addr), ipClient, INET_ADDRSTRLEN);
      printf("(%s:%u) : '%s'", ipClient, (unsigned)ntohs(adresseClient.sin_port), nom);
      if( !(strcasecmp(nom,"QUIT")==0) ) {
	strcpy(message, "Hello ");
	strcat(message, nom);
      }else
	strcpy(message, "Au revoir !");	
      if( write(socketClient, message, strlen(message))==-1 )
	erreur("write()");
      close(socketClient);
    }
  }
  close(socketServeur);
  return 1;
}
