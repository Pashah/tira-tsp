package tietorakenteet;


/**
 * @author Miika
 * @version 5.9.2012
 */
public class Kaupunki {
    
    int tunnisteNro;
    int xKoord;
    int yKoord;
    boolean onkoKayty;
    //Alkio[] alkiot = new Alkio[10];
    
    /**
     * Tyhja muodostaja
     */
    public Kaupunki(){
        
    }
    
    /**
     * Konstruktori, joka tekee kaupunki alkion
     * @param tunnisteNro alkion tunnistenumero
     * @param xKoord alkion x-koordinaatti
     * @param yKoord alkion y-koordinaatti
     * @param onkoKayty onko alkiossa kayty, aina alkutilanteessa false
     */
    public Kaupunki(int tunnisteNro, int xKoord, int yKoord,boolean onkoKayty) {
        this.tunnisteNro = tunnisteNro;
        this.xKoord = xKoord;
        this.yKoord = yKoord;
        this.onkoKayty = onkoKayty;
    }
    
    /**
     * Asettaa alkion käydyksi
     */
    public void setKaydyksi() {
        onkoKayty = true;
    }
    
    public void setEiKaydyksi() {
        onkoKayty = false;
    }
    
    /**
     *
     * @return tunnistenumero
     */
    public int getTunniste() {
        return tunnisteNro;
    }
    
    /**
     *
     * @return onko kaupungissa käyty
     */
    public boolean getKayty() {
        return onkoKayty;
    }
    
    /**
     *
     * @return x-koordinaatti
     */
    public int getX() {
        return xKoord;
    }
    
    /**
     *
     * @return y-koordinaatti
     */
    public int getY() {
        return yKoord;
    }
    
    /**
     *tulostaa alkion tiedot
     */
    public void tulosta() {
        System.out.println(tunnisteNro);
        System.out.println(xKoord);
        System.out.println(yKoord);
        System.out.println(onkoKayty);
    }
    
    /**
     *lisää alkion taulukkoon
     */
    public void lisaaAlkio() {
        //alkiot[tunnisteNro-1] = this;
    }

	/**
         * Testataan alkioita
	 * @param args
	 */
	public static void main(String[] args) {
            Kaupunki testi1 = new Kaupunki(1,2,2,false);
            Kaupunki testi2 = new Kaupunki(2,4,4,false);
            Kaupunki testi3 = new Kaupunki(3,5,2,false);
            Kaupunki testi4 = new Kaupunki(4,3,2,false);
            testi1.lisaaAlkio();
            testi2.lisaaAlkio();
            testi3.lisaaAlkio();
            testi4.lisaaAlkio();
            testi1.tulosta();
            testi2.tulosta();
            testi3.tulosta();
            testi4.tulosta();
	}
}
