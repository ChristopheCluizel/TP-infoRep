package HelloWorldRMI;
import HelloWorldRMI.Hello;
import HelloWorldRMI.ChaineVide;

public class HelloImpl implements Hello {
  public String sayHello(String nom) throws ChaineVide {
    if(nom.length()==0)
      throw new ChaineVide();
    System.out.println("Request from " + nom);
    return "Bonjour " + nom;
  }

  public void divisionParZero() {
    int tmp = 1/0;
  }
}
