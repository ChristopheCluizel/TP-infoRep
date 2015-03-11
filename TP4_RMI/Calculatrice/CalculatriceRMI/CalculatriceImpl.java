package CalculatriceRMI;
import CalculatriceRMI.Calculatrice;
import CalculatriceRMI.NombreNegatif;

public class CalculatriceImpl implements Calculatrice {
  public int addition(int a, int b) throws NombreNegatif {
   if(a<0 || b<0)
	throw new NombreNegatif();
   return a+b;
  }
   public int soustraction(int a, int b) throws  NombreNegatif{
   if(a<0 || b<0 || b>a)
	throw new NombreNegatif();
	
   return a-b;
   }
  public int multiplication(int a, int b) throws  NombreNegatif{
	   
   if(a<0 || b<0)
	throw new NombreNegatif();
   return a*b;
   }
  public int division(int a, int b) throws  NombreNegatif{
	   
   if(a<0 || b<0)
	throw new NombreNegatif();
	
   return a/b;
   }
}
