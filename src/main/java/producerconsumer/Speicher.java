package producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Speicher implements SpeicherIf {

    private int wert; //Actual counting value
    private boolean hatWert = false; //True if contains new unconsumed value

    /**
     * Gets the actual counting value
     * @return Actual counting value
     */
    @Override
    public synchronized int getWert() {
        while(!hatWert){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Wait on Speicher.getWert was interrupted");
                Logger.getLogger(Speicher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        hatWert = false;
        notifyAll(); //Wake up threads
        return wert;
    }

    /**
     * Sets the new counting value
     * @param wert New counting value
     */
    @Override
    public synchronized void setWert(int wert) {
        while(hatWert){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Wait on Speicher.setWert was interrupted");
                Logger.getLogger(Speicher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        hatWert = true;
        notifyAll(); //Wake up threads
        this.wert = wert;
    }

    /**
     * Indicates if the object contains a new unconsumed value
     * @return true if the object contains a new unconsumed value
     */
    @Override
    public boolean isHatWert() {
        return hatWert;
    }

}
