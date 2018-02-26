package producerconsumer;

import org.junit.Test;

import student.TestCase;

/**
 * Test Klasse für das Prgoramm ZaehlerDrucker
 * @author  Stefan Nyffenegger
 * @author  Marco Wyssmann
 * @author  Benjamin Steffen
 * @version 1.0
 */

public class ZaehlerDruckerTest extends TestCase {

    /**
     * Es wird getestet ob die Ausgabe den Erwartungen entspricht
     * 
     * @throws InterruptedException
     */

    @Test
    public void testZaehlerDrucker() throws InterruptedException {
	ZaehlerDrucker.main(new String[] { "1", "25" });
	assertFuzzyEquals("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 ",
		systemOut().getHistory());
    }

    /**
     * Es wird getestet ob der speicherThread und der druckerThread korrekt beendet
     * werden
     * 
     * @throws InterruptedException
     */

    @Test
    public void testThreadEnd() throws InterruptedException {

	ZaehlerDrucker.main(new String[] { "1", "25" });

	Thread zaehlerThread = new Thread();
	Thread druckerThread = new Thread();

	for (Thread t : ZaehlerDrucker.threads) {

	    if (t.getName().equals("zaehlerThread")) {
		zaehlerThread = t;
	    }
	    if (t.getName().equals("druckerThread")) {
		druckerThread = t;
	    }

	}

	assertEquals(Thread.State.TERMINATED, zaehlerThread.getState());
	assertEquals(Thread.State.TERMINATED, druckerThread.getState());
    }

}
