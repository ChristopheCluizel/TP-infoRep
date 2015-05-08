package institute;

import javax.jws.WebService;

@WebService(endpointInterface="institute.Secretariat")
public class SecretariatWS implements Secretariat {
  @Override
  public Student register(Candidate candidate, int testValue) throws ChaineVide {
    if(candidate.getName().length()==0)
      throw new ChaineVide();
    return new Student(candidate.getName(), 10/testValue);
  }
}
