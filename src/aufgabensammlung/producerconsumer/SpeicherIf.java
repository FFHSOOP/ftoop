package aufgabensammlung.producerconsumer;

public interface SpeicherIf {

	/**
	 * Gibt den aktuellen Wert zurück.
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public int getWert() throws InterruptedException;

	/**
	 * Setzt einen neuen aktuellen Wert.
	 * 
	 * @param wert
	 * @throws InterruptedException
	 */
	public void setWert(int wert) throws InterruptedException;

	/**
	 * Gibt true zurück, wenn es einen neuen, noch nicht konsumierten Wert im
	 * Objekt hat.
	 * 
	 * @return
	 */
	public boolean isHatWert();

}
