package producerconsumer;

/**
 * Der Aufruf benoetigt zwei Parameter min und max - der Zaehler beginnt bei min
 * zu zaehlen und terminiert bei max.
 *
 * @author  Stefan Nyffenegger
 * @author  Marco Wyssmann
 * @author  Benjamin Steffen
 * @version 1.0
 */
public class ZaehlerDrucker {

    static int wertMin;
    static int wertMax;
    static Thread[] threads;

    public static void main(String[] args) throws InterruptedException {

    // Verschiedene Tests bevor das eigentliche Programm initialisiert wird

	if (args.length != 2) {
	    System.out.println("Usage: ZaehlerDrucker <min> <max>");
	    System.exit(1);
	}

	try {
	    wertMin = Integer.parseInt(args[0]);
	    wertMax = Integer.parseInt(args[1]);
	} catch (NumberFormatException e) {
	    System.out.println("Bitte nur Zahlen eingeben!");
	    System.exit(1);
	}

	if (wertMin < 0 || wertMax < 0) {
	    System.out.println("Bitte nur positive Zahlen eingeben!");
	    System.exit(1);
	}

	if (wertMin > wertMax) {
	    System.out.println("Die erste Zahl muss keiner sein!");
	    System.exit(1);
	}

	Speicher s = new Speicher();
	Drucker d = new Drucker(s);
	Zaehler z = new Zaehler(s, ZaehlerDrucker.wertMin, wertMax);

	z.setName("zaehlerThread");
	d.setName("druckerThread");
	z.start();
	d.start();

	ThreadGroup gruppe = Thread.currentThread().getThreadGroup();
	int anzahlThreads = gruppe.activeCount();
	threads = new Thread[anzahlThreads];
	gruppe.enumerate(threads);

    // Wartezeit damit der Main Prozess nicht nach Initialisierung der Threads beendet wird
    int max = wertMax * 200;
	Thread.sleep(max);
    }

}
