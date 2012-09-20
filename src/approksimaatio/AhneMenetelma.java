package approksimaatio;

import tietorakenteet.Kaupunki;

/**
 * Etsii kauppamatkustajan ongelmaan lyhyimman polun käyttämällä ahnetta
 * menetelmää. Eli etenee aina lahimpaan solmuun, jossa ei ole viela kayty
 *
 * @author Miika
 */
public class AhneMenetelma {

    int solmujenLkm = 4;
    private Kaupunki[] ratkaisu = new Kaupunki[solmujenLkm];
    private Kaupunki[] kaupungit = new Kaupunki[solmujenLkm];
    private Kaupunki nykyinenKaupunki;
    
    /**
     * Testataan ahnetta menetelmää
     * @param args ei käytössä
     */
    public static void main (String args[]) {
        AhneMenetelma ahneTesti = new AhneMenetelma();
    }

    /**
     * Konstruktori, jossa lisätään ensin testikaupunkeja, jonka jälkeen
     * käydään läpi kaikki kaupungit
     * TODO: laita toimimaan niin, että alkukaupunki ei ole aina sama vaan
     * aloitusta kokeillaan jokaisesta kaupungista ja näistä reiteistä valitaan
     * sitten paras
     */
    public AhneMenetelma() {

        lisaaTestiKaup(); //Lisataan testikaupunkeja taulukkoon
        nykyinenKaupunki = kaupungit[0];
        ratkaisu[0] = nykyinenKaupunki;
        nykyinenKaupunki.setKaydyksi();

        int i = 1;
        while (i < ratkaisu.length) {
            nykyinenKaupunki = etsiMinimi(kaupungit);
            ratkaisu[i] = nykyinenKaupunki;
            nykyinenKaupunki.setKaydyksi();
            i++;
        }
        
        printtaaReitti(ratkaisu);

    }

    /**
     * Etsii nykyisen kaupungin lähimmän naapurin
     * @param kaupungit taulukko, jossa on kaikki kaupungit
     * @return kaupunki johon seuraavaksi mennään
     */
    private Kaupunki etsiMinimi(Kaupunki[] kaupungit) {

        int i = 0;
        Kaupunki seuraavaKaupunki = null;
        double min = Double.MAX_VALUE;

        while (i < kaupungit.length) {
            if (kaupungit[i].getKayty() == false && getEtaisyys(nykyinenKaupunki, kaupungit[i]) < min) {
                min = getEtaisyys(nykyinenKaupunki, kaupungit[i]);
                seuraavaKaupunki = kaupungit[i];
            }
            i++;
        }

        return seuraavaKaupunki;
    }

    /**
     * Palauttaa etäisyyden kaupungien välillä
     * @param nykyinenKaupunki kaupunki josta lähdetään
     * @param seurKaupunki kaupunki johon mennään
     * @return etäisyys kaupunkien välillä
     */
    private double getEtaisyys(Kaupunki nykyinenKaupunki, Kaupunki seurKaupunki) {

        double dx = nykyinenKaupunki.getX() - seurKaupunki.getX();
        double dy = nykyinenKaupunki.getY() - seurKaupunki.getY();
        double etaisyys = Math.sqrt(dx * dx + dy * dy);
        return etaisyys;
    }

    /**
     * Lisätään vaan joitain testikaupunkeja
     */
    private void lisaaTestiKaup() {
        kaupungit[0] = new Kaupunki(0, 1, 1, false);
        kaupungit[1] = new Kaupunki(1, 6, 6, false);
        kaupungit[2] = new Kaupunki(2, 2, 2, false);
        kaupungit[3] = new Kaupunki(3, 1, 2, false);
    }

    /**
     * Tulostaa reitin, jonka ahne menetelmä antoi
     * @param ratkaisu ratkaisureitti
     */
    private void printtaaReitti(Kaupunki[] ratkaisu) {
        for (int i = 0; i < ratkaisu.length; i++) {
            System.out.println(ratkaisu[i].getTunniste());
        }
    }
}
