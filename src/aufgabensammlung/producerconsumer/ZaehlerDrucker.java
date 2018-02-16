package aufgabensammlung.producerconsumer;

/**
 * 
 * Der Aufruf benötigt zwei Parameter min und max - der Zaehler beginnt bei min
 * zu zaehlen und terminiert bei max.
 * 
 */

public class ZaehlerDrucker {

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 2) {
			System.out.println("Usage: ZaehlerDrucker <min> <max>");
			System.exit(1);
		}

		Speicher s = null; // new Speicher();
		Drucker d = new Drucker(s);
		Zaehler z = new Zaehler(s, Integer.parseInt(args[0]),
				Integer.parseInt(args[1]));

		z.start();
		d.start();

		// bissi warten, damit der Test funktioniert
		Thread.sleep(5000);

	}

}
