import institute.*;

public class Client {
  public static void main(String[] args) throws java.lang.Exception {
    Secretariat secretariat = (new institute.SecretariatWSService()).getSecretariatWSPort();
    Candidate candidate = new Candidate();
    if(args.length == 2)
      candidate.setName(args[0]);
    Student student = secretariat.register(candidate, Integer.parseInt(args[args.length-1]));
    System.out.println(student.getName() + " est bien inscrit. Valeur de test : " + student.getTestValue());
  }
}
