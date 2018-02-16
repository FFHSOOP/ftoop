package aufgabensammlung.producerconsumer;

//TODO Entfernen Sie den abstract modifier und implementieren Sie die fehlenden Methoden!
public class Speicher implements SpeicherIf {

    private int wert;
    private boolean hatWert = false;

    @Override
    public int getWert() {
        return wert;
    }

    @Override
    public void setWert(int wert) {
        this.wert = wert;
    }

    @Override
    public boolean isHatWert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
