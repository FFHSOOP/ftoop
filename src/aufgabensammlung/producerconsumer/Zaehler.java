package aufgabensammlung.producerconsumer;

public class Zaehler extends Thread {

	private Speicher speicher;
	private int max, min;

	/**
	 * 
	 * @param s
	 *            Das Speicherobject, das die aktuelle Zahl haelt.
	 * @param min
	 *            Der Startwert für den Zaehler
	 * @param max
	 *            Der Endwert für den Zaehler (einschliesslich)
	 * 
	 */
	Zaehler(Speicher s, int min, int max) {
		this.speicher = s;
		this.max = max;
		this.min = min;
	}

	/**
	 * Diese Run Methode zählt den Wert in Speicher hoch - von min bis max
	 * (einschliesslich).
	 * 
	 */
	@Override
	public void run() {
		// TODO Implementieren Sie den Zaehler
	}

}
