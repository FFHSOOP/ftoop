package producerconsumer;

// TODO Entfernen Sie den abstract modifier und implementieren Sie die fehlenden Methoden!
// Half done by SN

public class Speicher implements SpeicherIf {

    private int wert;
    private boolean hatWert = false;

    @Override
    public int getWert() {
        hatWert = false;
        return wert;
    }

    @Override
    public void setWert(int wert) {
        hatWert = true;
        this.wert = wert;
    }

    @Override
    public boolean isHatWert() {
        return hatWert;
    }

}
