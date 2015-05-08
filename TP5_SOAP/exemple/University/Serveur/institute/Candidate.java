package institute;

public class Candidate {
  private String name;

  public Candidate ()
    { this.name = ""; }

  public Candidate (String name)
    { this.name = name; }

  public void setName(String name)
    { this.name = name; }

  public String getName()
    { return this.name; }
}
