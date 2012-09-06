package tietorakenteet;


/**
 * @author Miika
 * @version 5.9.2012
 */
public class Alkio {
    
    int tunnisteNro;
    Alkio seuraava;
    Alkio edellinen;
    int xKoord;
    int yKoord;
    boolean onkoKayty;
    
    /**
     * Tyhjä muodostaja
     */
    public Alkio(){
        
    }
    
    /**
     * @param tunnisteNro alkion tunnistenumero
     * @param seuraava alkion seuraava alkio listassa
     * @param edellinen alkion edellinen alkio listassa
     * @param xKoord alkion x-koordinaatti
     * @param yKoord alkion y-koordinaatti
     * @param onkoKayty onko alkiossa käyty, aina alkutilanteessa true
     */
    public Alkio(int tunnisteNro, Alkio seuraava, Alkio edellinen, int xKoord, int yKoord,boolean onkoKayty) {
        this.tunnisteNro = tunnisteNro;
        this.seuraava = seuraava;
        this.edellinen = edellinen;
        this.xKoord = xKoord;
        this.yKoord = yKoord;
        this.onkoKayty = onkoKayty;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
