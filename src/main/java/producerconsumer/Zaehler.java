package producerconsumer;

public class Zaehler extends Thread {

    private Speicher speicher;
    private int max, min;

    /**
     *
     * @param s Das Speicherobject, das die aktuelle Zahl haelt.
     * @param min Der Startwert für den Zaehler
     * @param max Der Endwert für den Zaehler (einschliesslich)
     *
     */
    Zaehler(Speicher s, int min, int max) {
        this.speicher = s;
        this.max = max;
        this.min = min;
    }

    /**
     * Diese Run Methode zählt den Wert in Speicher hoch - von min bis max
     * (einschliesslich).
     *
     */
    @Override
    public void run() {
        int temp = this.min;
        while (temp <= this.max && !this.speicher.isHatWert()) {
            if (temp == this.max) {
                
            }
            try {
                this.speicher.setWert(temp);
                temp = temp + 1;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        speicher.setLast(true); //Markiert diesen Wert als den letzten
    }

}
