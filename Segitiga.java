/**
 * @author Jhonathan Oktavianus 1972046
 */

public class Segitiga {
    double alas, tinggi;

    public Segitiga(){
    }

    public Segitiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public double getAlas() {
        return alas;
    }

    public void setAlas(double alas) {
        this.alas = alas;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    public double getLuasSegitiga(){
        double rumus = 0.5*this.alas*this.tinggi;
        return rumus;
    }
}