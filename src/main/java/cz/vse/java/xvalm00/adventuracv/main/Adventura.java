package cz.vse.java.xvalm00.adventuracv.main;

import cz.vse.java.xvalm00.adventuracv.logika.Hra;
import cz.vse.java.xvalm00.adventuracv.logika.IHra;
import cz.vse.java.xvalm00.adventuracv.uiText.TextoveRozhrani;

public class Adventura {

    /***************************************************************************
     * Metoda, jejímž prostřednictvím se spouští celá aplikace.
     *
     * @param args parametry příkazového řádku
     */
    public static void main(String[] args) {
        IHra hra = new Hra();//Comment
        TextoveRozhrani ui = new TextoveRozhrani(hra);
        ui.hraj();
    }
}
