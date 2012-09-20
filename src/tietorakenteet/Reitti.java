package tietorakenteet;

/**
 *
 * @author Miika
 */
public class Reitti {

    Kaupunki lahtoKaupunki;
    Kaupunki menoKaupunki;
    double hinta;
    boolean kayty;

    public Reitti(Kaupunki lahtoKaupunki, Kaupunki tuloKaupunki, double hinta, boolean kayty) {
        this.lahtoKaupunki = lahtoKaupunki;
        this.menoKaupunki = tuloKaupunki;
        this.hinta = hinta;
        this.kayty = kayty;
    }

    public Kaupunki getLahtoKaupunki() {
        return lahtoKaupunki;
    }

    public void setLahtoKaupunki(Kaupunki lahtoKaupunki) {
        this.lahtoKaupunki = lahtoKaupunki;
    }

    public Kaupunki getTuloKaupunki() {
        return menoKaupunki;
    }

    public void setTuloKaupunki(Kaupunki tuloKaupunki) {
        this.menoKaupunki = tuloKaupunki;
    }

    public double getHinta() {
        return hinta;
    }

    public void setHinta(double hinta) {
        this.hinta = hinta;
    }

    @Override
    public String toString() {
        return "Lahto: " + lahtoKaupunki.getTunniste() + "Minne: " + menoKaupunki.getTunniste() + "Hinta: " + hinta;
    }
}
