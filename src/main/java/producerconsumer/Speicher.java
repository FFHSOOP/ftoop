package producerconsumer;

public class Speicher implements SpeicherIf {

    private int wert; // aktuell im Speicher gehaltener Wert
    private boolean hatWert = false; // true wenn ein nicht ausgelesener Wert vorhanden ist
    private boolean isLast = false; // true wenn der Wert im Speicher der letzte Wert ist

    /**
     * Gibt den aktuell im Speicher gehaltenen wert zurueck
     * 
     * @return aktuell gezaehlter Wert
     */
    @Override
    public synchronized int getWert() {
	while (!hatWert) {
	    try {
		if (isLast)
		    return -1;
		wait();
	    } catch (InterruptedException ex) {
		break;
	    }
	}
	int tmp = wert; // stellt sicher, dass der Zaehler den Wert nicht ueberschreibt
	hatWert = false;
	notify(); // benachrichtigt Threads
	return tmp;
    }

    /**
     * Setzt den neuen Wert im Speicher
     * 
     * @param wert
     *            neuer Zaehlwert
     */
    @Override
    public synchronized void setWert(int wert) {
	while (hatWert) {
	    try {
		wait();
	    } catch (InterruptedException ex) {
		break;
	    }
	}
	this.wert = wert;
	hatWert = true;
	notify(); // benachrichtigt Threads
    }

    /**
     * zeigt an, ob der Speicher einen neuen Wert enthaelt, der vom Drucker noch
     * nicht abgeholt wurde
     * 
     * @return true wenn der Speicher einen Wert enthaelt
     */
    @Override
    public boolean isHatWert() {
	return hatWert;
    }

    /**
     * Gibt an, ob der aktuelle Wert der letzte Wert ist.
     * 
     * @return true wenn der aktuelle Wert im Speicher der letzte ist.
     */
    public boolean isLast() {
	return isLast;
    }

    /**
     * Zeigt an, dass der letzte Wert erreicht ist und benachrichtigt die wartenden
     * Threads.
     * 
     * @param isLast
     *            bei true wird kein weiterer Wert folgen
     */
    public synchronized void setLast(boolean isLast) {
	this.isLast = isLast;
	notifyAll(); // benachrichtigt Threads
    }
}
