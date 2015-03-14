import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import calculatrice.Calculatrice;

public class Client {
  public static void main(String args[]) {
    String machine = "localhost";
    int port = 1099;

    try {
        Registry registry = LocateRegistry.getRegistry(machine, port);
        Calculatrice obj = (Calculatrice)registry.lookup("Calculatrice");

        int nb1 = Integer.parseInt(args[0]);
        int nb2 = Integer.parseInt(args[2]);
        String operateur = args[1];

        if(operateur.equals("+"))
            System.out.println(nb1 + " + " + nb2 + " = " + obj.addition(nb1, nb2));

        else if(operateur.equals("-"))
            System.out.println(nb1 + " - " + nb2 + " = " + obj.soustraction(nb1, nb2));

        else if(operateur.equals("x"))
            System.out.println(nb1 + " * " + nb2 + " = " + obj.multiplication(nb1, nb2));

        else if(operateur.equals("/"))
            System.out.println(nb1 + " / " + nb2 + " = " + obj.division(nb1, nb2));

        else
            System.out.println("Commande inconnue");

    } catch (Exception e) {
       System.out.println("Client exception: " +e);
    }
  }
}
