package producerconsumer;

public class Speicher implements SpeicherIf {

    private int wert; //Actual counting value
    private boolean hatWert = false; //True if contains new unconsumed value
    private boolean isLast = false; //True if this value is the last one

    /**
     * Gets the actual counting value
     * @return Actual counting value
     */
    @Override
    public synchronized int getWert() {
        while(!hatWert){
            try {
                if(isLast) return -1;
                wait();
            } catch (InterruptedException ex) {
                break;
            }
        }
        int tmp = wert; //Make shure that Zaehler does not overwrite the value
        hatWert = false;
        notify(); //Wake up threads
        return tmp;
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
                break;
            }
        }
        this.wert = wert;
        hatWert = true;
        notify(); //Wake up threads
    }

    /**
     * Indicates if the object contains a new unconsumed value
     * @return true if the object contains a new unconsumed value
     */
    @Override
    public boolean isHatWert() {
        return hatWert;
    }
    
    /**
     * Returns true if this is the last new value
     * @return true if contained value is the last one
     */
    public boolean isLast() {
        return isLast;
    }
    
    /**
     * Sets the value to be the last one arriving and notifies waiting threads
     * @param isLast if true no new values will arrive
     */
    public synchronized void setLast(boolean isLast) {
        this.isLast = isLast;
        notifyAll(); //Wake up threads
    }
}
