package calculatriceComplexe;

public class CalculatriceImpl implements Calculatrice {
	public Complexe addition(Complexe a, Complexe b) {
		return a.plus(b);
	}
	public Complexe soustraction(Complexe a, Complexe b) {
	   return a.minus(b);
	}
	public Complexe multiplication(Complexe a, Complexe b) {
	  return a.times(b);
	}
	public Complexe division(Complexe a, Complexe b) {
	  return a.divides(b);
	}
}
