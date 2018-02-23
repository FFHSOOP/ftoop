package producerconsumer;

/**
 *
 * Der Aufruf benoetigt zwei Parameter min und max - der Zaehler beginnt bei min
 * zu zaehlen und terminiert bei max.
 *
 */
public class ZaehlerDrucker {

    static int wertMin;
    static int wertMax;
    static Thread[] threads;

    public static void main(String[] args) throws InterruptedException {
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

	// bissi warten, damit der Test funktioniert
	int max = wertMax * 200;
	Thread.sleep(max);

	// System.out.println("laenge:" + threads.length);
	// System.out.println(threads[0].getName() + "," + threads[1].getName() + "," +
	// threads[2].getName());
	// System.out.println(threads[0].getState() + "," + threads[1].getState() + ","
	// + threads[2].getState());
    }

}
