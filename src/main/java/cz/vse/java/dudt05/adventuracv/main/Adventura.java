package cz.vse.java.dudt05.adventuracv.main;

import cz.vse.java.dudt05.adventuracv.logika.Hra;
import cz.vse.java.dudt05.adventuracv.logika.IHra;
import cz.vse.java.dudt05.adventuracv.uiText.TextoveRozhrani;

public class Adventura {

    /***************************************************************************
     * Metoda, jejímž prostřednictvím se spouští celá aplikace.
     *
     * @param args parametry příkazového řádku
     */
    public static void main(String[] args) {
        IHra hra = Hra.getSingletone();
        TextoveRozhrani ui = new TextoveRozhrani(hra);
        ui.hraj();
    }
}
