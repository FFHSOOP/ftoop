package producerconsumer;

/**
 * Drucker Klasse gibt Wert aus Speicher aus
 * @author  Stefan Nyffenegger
 * @author  Marco Wyssmann
 * @author  Benjamin Steffen
 * @version 1.0
 */

public class Drucker extends Thread {

    private Speicher speicher;

    Drucker(Speicher s) {
	this.speicher = s;
    }

    /**
     * Holt einen Wert vom Zaehler und gibt ihn aus, gefolgt von einem einzelnen
     * Leerzeichen.
     *
     */
    @Override
    public void run() {
	while (!speicher.isLast()) {
	    int wert = speicher.getWert();
	    try {
		if (wert < 0)
		    break;
		System.out.print(wert + " ");
		Thread.sleep(100);
	    } catch (InterruptedException e) {
		break;
	    }
	}
    }
    
}
