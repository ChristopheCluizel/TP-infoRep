package institute;

public class Student {
  private String name;
  private int testValue;

  public Student()
    { this.name = ""; this.testValue = 0; }

  public Student(String name, int testValue)
    { this.name = name; this.testValue = testValue; }

  public void setName(String name)
    { this.name = name; }

  public void setTestValue(int testValue)
    { this.testValue = testValue; }

  public String getName()
    { return this.name; }

  public int getTestValue()
    { return this.testValue; }
}
