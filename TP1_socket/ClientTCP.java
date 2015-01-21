import java.io.*;
import java.util.*;
import java.net.*;

public  class ClientTCP {

  public static void main(String[] args) throws Exception {
    Socket s;
    PrintStream socketOutputStream;
    BufferedReader socketInputStream;
    StringTokenizer tokens;
    int erreur;
    String reponse;

    if(args.length != 3) {
      System.out.println("3 arguments : Opérande gauche, opérateur, opérateur droit");
      System.out.println("Valeur attendue en retour : \"Opérande gauche + opérande droit\"");
    }
    else {
      s = new Socket("172.18.17.178", 2000);
      socketOutputStream = new PrintStream(s.getOutputStream());
      socketOutputStream.print(args[0] + args[1] + args[2] + "\n");
      socketInputStream = new BufferedReader(new InputStreamReader(s.getInputStream()));

      if((reponse = socketInputStream.readLine()) != null)
      // reponse = socketInputStream.readLine();
        System.out.println("reponse:" + reponse);
      else
        System.out.println("Reponse vide !");
    }
  }
}

// reponse = (char)socketInputStream.read();
