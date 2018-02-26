
package producerconsumer;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests zur Funktionsweise der Speicher Klasse
 *
 */
public class SpeicherTest {

    Speicher speicher = new Speicher();

    public class Runner implements Runnable {

	int tempWert;

	public int getTempWert() {
	    return tempWert;
	}

	public void run() {

	    tempWert = speicher.getWert();

	}
    }

    /**
     * Test method for {@link producerconsumer.Speicher#isHatWert()}.
     */
    @Test
    public void testIsHatWert() {
	assertFalse(speicher.isHatWert());
    }

    /**
     * Test method for {@link producerconsumer.Speicher#setWert(int)}.
     */
    @Test
    public void testSetWert() {

	Thread worker = new Thread(new Runnable() {
	    public void run() {
		speicher.setWert(5); // Testen ob der Wert richtig geschrieben wird
		speicher.setWert(2); // Test ob der erste Wert ueberschrieben wird
	    }
	});
	worker.start();
	try {
	    Thread.sleep(100);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	// testen ob der Thread wartet, da bereits ein Wert geschrieben wurde
	assertEquals(Thread.State.WAITING, worker.getState());

    }

    
    //funktioniert noch nicht der Wert wurde auf 5 gesetzt
    
    /**
     * Test method for {@link producerconsumer.Speicher#getWert()}.
     */
    @Test
    public void testGetWert() {
	
	Runner runner = new Runner(); 
	Thread worker2 = new Thread (runner);
		

	worker2.start();
//	int wert = runner.getTempWert();
	
	
	assertEquals(1, runner.getTempWert()); // Test ob der richtige Wert zurueckgegeben wird
	assertFalse(speicher.isHatWert()); // Test ob der Wert abgeholt wurde
    }

    /**
     * Test method for {@link producerconsumer.Speicher#isLast()}.
     */
    @Test
    public void testIsLast() {
	assertFalse(speicher.isLast());
    }

    /**
     * Test method for {@link producerconsumer.Speicher#setLast(boolean)}.
     */
    @Test
    public void testSetLast() {
	speicher.setLast(true);
	assertTrue(speicher.isLast());
    }

}
