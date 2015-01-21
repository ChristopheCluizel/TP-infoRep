import java.io.*;
import java.util.*;
import java.net.*;

public  class Main {

  public static void main(String[] args) throws Exception {
    Socket s;
    PrintStream socketOutputStream;
    BufferedReader socketInputStream;
    StringTokenizer tokens;
    int erreur;
    String reponse;

    if(args.length != 4) {
      System.out.println("4 arguments : IP Port Nom Age)"); 
      System.out.println("Valeur attendue en retour : \"Salut Nom !\""); 
    }
    else {
      s = new Socket(args[0], Integer.parseInt(args[1]));
      socketOutputStream = new PrintStream(s.getOutputStream());
      socketOutputStream.print(args[2] + " " + args[3] + "\n");
      socketInputStream = new BufferedReader(new InputStreamReader(s.getInputStream()));
      if( (reponse=socketInputStream.readLine())!= null)
        System.out.println(reponse);
      else
        System.out.println("Reponse vide !");
    }
  }
}
