package CalculatriceRMI;
import CalculatriceRMI.Calculatrice;
import CalculatriceRMI.Complex;

public class CalculatriceImpl implements Calculatrice {
	public Complex addition(Complex a, Complex b) {
		return a.plus(b);
	}
	public Complex soustraction(Complex a, Complex b) {
	   return a.minus(b);
	}
	public Complex multiplication(Complex a, Complex b) {
	  return a.times(b);
	}
	public Complex division(Complex a, Complex b) {
	  return a.divides(b);
	}
}
