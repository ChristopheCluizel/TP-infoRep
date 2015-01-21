import java.io.*;
import java.net.*;


public class ClientUDP
{
  final static int taille = 1024;
  final static byte buffer[] = new byte[taille];

  public static void main(String args[]) throws Exception
    {
      String message = args[0] + args[1] + args[2] + "\n";  // creation du message
      InetAddress serveur = InetAddress.getByName("172.18.17.178"); // assignation de l'adresse ip du serveur
      int length = message.length();
      byte buffer[] = message.getBytes();
      DatagramPacket dataSent = new DatagramPacket(buffer, length, serveur, 2000);  // creation du datagramme
      DatagramSocket socket = new DatagramSocket();

      socket.send(dataSent);

      DatagramPacket dataReceived = new DatagramPacket(new byte[100], 100); // 100 est le nombre de caractères que l'on peut recevoir
      socket.receive(dataReceived);
      System.out.println("Data received : " + new String(dataReceived.getData()));
      System.out.println("From : " + dataReceived.getAddress() + ":" + dataReceived.getPort());
    }
}
