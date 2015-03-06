import HelloWorld.*;
import HelloWorld.HelloPackage.*;

class HelloServant extends HelloPOA {
  public String sayHello(String name) throws ChaineVide {
    if(name.equals(""))
	throw new ChaineVide();
    System.out.println("Request from " + name);
    return "Hello "+name;
  }
  public int addition(int a,int b) throws Negatif {
	  if(a<0 || b<0) throw new Negatif();
	  return a+b;
  }  
  public int soustraction(int a,int b) throws Negatif {
	  if(a<0 || b<0 || a-b<0) throw new Negatif();
	  return a-b;
  }  
  public int multiplication(int a,int b) throws Negatif {
	  if(a<0 || b<0) throw new Negatif();
	  return a*b;
  }  
  public int division(int a,int b) throws Negatif, DivisionParZero  {
	  if(a<0 || b<0) throw new Negatif();
	  if(b==0) throw new DivisionParZero();
	  return a/b;
  }  
  
  
}

