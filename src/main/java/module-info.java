module cz.vse.xvalm00.adventuracv {
    requires javafx.controls;
    requires javafx.fxml;


    opens cz.vse.java.dudt05.adventuracv.main to javafx.fxml;
    exports cz.vse.java.dudt05.adventuracv.main;
}