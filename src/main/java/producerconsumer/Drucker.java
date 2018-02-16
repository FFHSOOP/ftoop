package producerconsumer;

public class Drucker extends Thread {

    private Speicher speicher;

    Drucker(Speicher s) {
        this.speicher = s;
    }

    /**
     * Holt einen Wert vom Zaehler und gibt ihn aus, gefolgt von einem einzelnen
     * Leerzeichen.
     *
     */
    @Override
    public void run() {
        while (this.speicher.isHatWert()) {
            try {
                System.out.print(speicher.getWert() + " ");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                interrupt();
                System.out.println("Drucker thread interrupted");
                break; //end loop
            }
        }

    }

}
