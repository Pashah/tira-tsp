package optimaalinen;

import java.util.ArrayList;
import tietorakenteet.Kaupunki;
import tietorakenteet.Reitti;

/**
 * Branch and bound on peruuttavaa hakua rajoittava menetelmä. Ratkaisen sillä
 * tsp ongelman optimaalisen ratkaisun
 *
 * @author Miika
 */
public class BranchAndBound {

    int kaupunkienLkm = 4;
    private Kaupunki[] ratkaisu = new Kaupunki[kaupunkienLkm];
    private Kaupunki nykyinenKaupunki;
    private Kaupunki[] kaupungit = new Kaupunki[kaupunkienLkm];
    private ArrayList<Reitti> reitit = new ArrayList<Reitti>();
    private double valimatkat[][] = new double[kaupunkienLkm][kaupunkienLkm];

    public static void main(String args[]) {

        BranchAndBound testibb = new BranchAndBound();
    }

    public BranchAndBound() {

        double parhaanRatkaisunHinta = Double.MAX_VALUE;

        lisaaTestiKaupungit();

        luoReitti();
        tulostaReitit();
        
        nykyinenKaupunki = kaupungit[0];
        nykyinenKaupunki.setKaydyksi();
        double p = generoi(parhaanRatkaisunHinta, 0, nykyinenKaupunki, 1);
        System.out.println(p);
        
    }

    private double generoi(double parhaanRatkaisunHinta, double matka, Kaupunki nykyinenKaupunki, int kaydytKaup) {
        if (kaydytKaup == kaupunkienLkm + 1) {
            return matka + valimatkat[nykyinenKaupunki.getTunniste()][1];
        }
        double paras = Double.MAX_VALUE;
        for (int i = 1; i < kaupungit.length; i++) {
            if (kaupungit[i].getKayty() == false) {
                Kaupunki kaupunki2 = luoKopio(kaupungit[i]);
                kaupunki2.setKaydyksi();
                if (matka + valimatkat[nykyinenKaupunki.getTunniste()][i] < parhaanRatkaisunHinta) {
                    double pituus = generoi(parhaanRatkaisunHinta, matka + valimatkat[nykyinenKaupunki.getTunniste()][i], kaupunki2, kaydytKaup + 1);
                    if (pituus < paras) {
                        paras = pituus;
                    }
                    if (pituus < parhaanRatkaisunHinta) {
                        parhaanRatkaisunHinta = pituus;
                    }
                }
            }
        }
        return paras;
    }

    private void lisaaTestiKaupungit() {
        kaupungit[0] = new Kaupunki(0, 1, 1, false);
        kaupungit[1] = new Kaupunki(1, 6, 6, false);
        kaupungit[2] = new Kaupunki(2, 2, 2, false);
        kaupungit[3] = new Kaupunki(3, 1, 2, false);
    }

    private void luoReitti() {
        for (int i = 0; i < kaupungit.length; i++) {
            for (int j = 0; j < kaupungit.length; j++) {
                valimatkat[i][j] = laskeReitti(kaupungit[i], kaupungit[j]);
            }
        }
    }

    private double laskeReitti(Kaupunki lahtoKaupunki, Kaupunki tuloKaupunki) {
        double dx = lahtoKaupunki.getX() - tuloKaupunki.getX();
        double dy = lahtoKaupunki.getY() - tuloKaupunki.getY();
        double etaisyys = Math.sqrt(dx * dx + dy * dy);
        return etaisyys;
    }

    private void tulostaReitit() {
        for (int i = 0; i < valimatkat.length; i++) {
            for (int j = 0; j < valimatkat.length; j++) {
                System.out.println("Reitti: " + i + " " + j);
                System.out.println(valimatkat[i][j]);
            }
        }
    }

    private Kaupunki luoKopio(Kaupunki kaupunki) {
        return new Kaupunki(kaupunki.getTunniste(), kaupunki.getX(), kaupunki.getY(), false);
    }
}
