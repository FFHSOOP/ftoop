package producerconsumer;

public class Zaehler extends Thread {

    private Speicher speicher;
    private int max, min;
    
    /**
     * @param s   Das Speicherobject, das die aktuelle Zahl haelt.
     * @param min Der Startwert fuer den Zaehler
     * @param max Der Endwert fuer den Zaehler (einschliesslich)
     *
     */
    Zaehler(Speicher s, int min, int max) {
	this.speicher = s;
	this.max = max;
	this.min = min;
    }

    /**
     * Diese Run Methode zaehlt den Wert im Speicher hoch - von min bis max
     * (einschliesslich).
     *
     */
    @Override
    public void run() {
	int temp = this.min;
	while (temp <= this.max && !this.speicher.isHatWert()) {
	    try {
		this.speicher.setWert(temp);

		if (temp == this.max) {
		    while (this.speicher.isHatWert()) {
			Thread.sleep(100);
		    }
		    speicher.setLast(true); // Markiert diesen Wert als den letzten
		    break;
		}

		temp = temp + 1;

		Thread.sleep(100);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	// System.out.print("zaehler over");
	// System.out.println(Thread.currentThread().getName());
    }

}
