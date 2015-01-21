#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <time.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>

int ouvrirSocket(char* adresseIP, char* portTCP) {
  struct sockaddr_in *adresseIPServeur;
  int idSocket;

  adresseIPServeur = (struct sockaddr_in *)malloc(sizeof(struct sockaddr_in));
  adresseIPServeur->sin_family = AF_INET;
  adresseIPServeur->sin_port = htons(atoi(portTCP)); // String -> Integer -> uint16_t
  adresseIPServeur->sin_addr.s_addr = inet_addr(adresseIP);
  if( adresseIPServeur->sin_addr.s_addr == INADDR_NONE ) {
    fprintf(stderr, "Mauvaise adresse pour le Socket\n");
    exit(0);
  }
  idSocket = socket(PF_INET, SOCK_STREAM, 0);
  if(idSocket == -1) {
    fprintf(stderr, "Socket impossible a creer\n");
    exit(0);
  }
  if( bind(idSocket, (struct sockaddr*)adresseIPServeur, sizeof(*adresseIPServeur)) == -1) {
    fprintf(stderr, "Le Socket ne peut pas etre lie\n");
    exit(0);
  }
  if(listen(idSocket, 10) == -1) {
    fprintf(stderr, "Erreur a la mise en ecoute du Socket\n");
    exit(0);
  }
  return idSocket;
}

void traiterRequete(int idSocketClient) {
  FILE* fluxSortie;
  FILE* fluxEntree;
  char* nom = (char*)malloc(sizeof(char)*50);
  int age;

  fluxEntree = fdopen(idSocketClient,"r");
  if (fluxEntree != NULL) {
    fluxSortie = fdopen(dup(idSocketClient),"w");
    if (fluxSortie!=NULL) {
      fscanf(fluxEntree,"%s %d", nom, &age);
      printf("Requete de %s, %d ans\n", nom, age);
      fprintf(fluxSortie,"Salut %s !\n", nom);
    }
    fclose(fluxEntree);
    fclose(fluxSortie);
  } else {
    fclose(fluxEntree);
  }
}

void run(int idSocket) {
  int idSocketClient = -1;
  pid_t PID;
  int longueurAdresseIPClient;
  struct sockaddr_in adresseIPClient;

  while(1) {
    longueurAdresseIPClient = sizeof(adresseIPClient);
    idSocketClient = accept(idSocket,(struct sockaddr *) &adresseIPClient, &longueurAdresseIPClient);
    if ( idSocketClient == -1 ) {
      fprintf(stderr, "Socket client impossible a accepter\n");
    }
    else {
      if ( (PID = fork()) == -1 ) {
        close(idSocketClient);
        continue;
      } else if ( PID > 0 ) {
        close(idSocketClient);
        continue;
      }
      traiterRequete(idSocketClient);
      exit(0);
    }
  }
}

int main(int argc, char **argv) {
  int idSocket = -1;

  if(argc != 3){
    fprintf(stderr, "Commande : serveur [Adresse IP [Port]]\n");
    exit(0);
  }
  idSocket = ouvrirSocket(argv[1], argv[2]);
  run(idSocket);
  close(idSocket);
  return 0;
}
