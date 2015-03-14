package calculatriceComplexe;

import java.io.Serializable;

public class Complexe implements Serializable{
    private final double re;   // the real part
    private final double im;   // the imaginary part

    // create a new object with the given real and imaginary parts
    public Complexe(double real, double imag) {
        re = real;
        im = imag;
    }

    // return a string representation of the invoking Complexe object
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    // return abs/modulus/magnitude and angle/phase/argument
    public double abs()   { return Math.hypot(re, im); }  // Math.sqrt(re*re + im*im)
    public double phase() { return Math.atan2(im, re); }  // between -pi and pi

    // return a new Complexe object whose value is (this + b)
    public Complexe plus(Complexe b) {
        Complexe a = this;             // invoking object
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complexe(real, imag);
    }

    // return a new Complexe object whose value is (this - b)
    public Complexe minus(Complexe b) {
        Complexe a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complexe(real, imag);
    }

    // return a new Complexe object whose value is (this * b)
    public Complexe times(Complexe b) {
        Complexe a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complexe(real, imag);
    }

    // return a new Complexe object whose value is the conjugate of this
    public Complexe conjugate() {  return new Complexe(re, -im); }

    // return a new Complexe object whose value is the reciprocal of this
    public Complexe reciprocal() {
        double scale = re*re + im*im;
        return new Complexe(re / scale, -im / scale);
    }

    // return the real or imaginary part
    public double re() { return re; }
    public double im() { return im; }


    public Complexe divides(Complexe b) {
        Complexe a = this;
        return a.times(b.reciprocal());
    }
}
