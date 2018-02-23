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
        while (!speicher.isLast()) {
            int wert = speicher.getWert();
            try {
                if (wert<0) break;
                System.out.print(wert + " ");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
        //System.out.print("drucker over");
       // System.out.println(Thread.currentThread().getName());
    }
}
