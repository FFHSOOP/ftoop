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
        while (true) {
            int wert = speicher.getWert();
            if(wert == -1){
                return;
            }
            try {
                System.out.print(wert + " ");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                interrupt();
                break;
            }
        }
    }
}
