package producerconsumer;

import org.junit.Test;

import student.TestCase;


public class ZaehlerDruckerTest extends TestCase {

	public void testZaehlerDrucker() throws InterruptedException {
		ZaehlerDrucker.main(new String[] { "1", "25" });
		assertFuzzyEquals(
				"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 ",
				systemOut().getHistory());
	}

	// TODO Fuegen Sie einen eigenen Test ein.
	
	
	 @Test
	    public void testThreadEnd() throws InterruptedException {
	     
	     ZaehlerDrucker.main(new String[] { "1", "25" });
	     
	     
	     
	    /**
	     ThreadGroup gruppe = Thread.currentThread().getThreadGroup();
	     int anzahlThreads = gruppe.activeCount();
	     Thread[] threads = new Thread[anzahlThreads];
	     gruppe.enumerate(threads);
	     
	     Thread speicherThread = threads[1];
	     Thread druckerThread = threads[2];
	      System.out.println("laenge:" + threads.length);
	     System.out.println(threads[0].getName() + threads[1].getName() + threads[2].getName());
	     System.out.println("WORT");
	     
	     */
	     
	     Thread speicherThread = ZaehlerDrucker.threads[1];
	     Thread druckerThread = ZaehlerDrucker.threads[2];
	     
	     assertEquals(Thread.State.TERMINATED, speicherThread.getState());
	     assertEquals(Thread.State.TERMINATED, druckerThread.getState());
	  //   assertEquals(Thread.State.TIMED_WAITING, speicherThread.getState());
	  //   assertEquals(Thread.State.TIMED_WAITING, druckerThread.getState());
	     
	    }
	
	
}
