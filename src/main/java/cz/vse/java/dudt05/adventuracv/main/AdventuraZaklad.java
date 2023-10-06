package cz.vse.java.dudt05.adventuracv.main;

import cz.vse.java.dudt05.adventuracv.logika.Hra;
import cz.vse.java.dudt05.adventuracv.logika.IHra;
import cz.vse.java.dudt05.adventuracv.uiText.TextoveRozhrani;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AdventuraZaklad extends Application {

    public static void main(String[] args) {
        if (args.length == 0) {
            launch(args);
        }
        else {
            if(args[0].equals("-text")) {
                IHra hra = new Hra();
                TextoveRozhrani ui = new TextoveRozhrani(hra);
                ui.hraj();
            }
            else if(args[0].equals("-gui")) {
                launch(args);
            }
            else {
                System.out.println("Wrong parameter was entered");
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(new Label("Hello World!"));

        Scene scene = new Scene(borderPane,300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Adventura");
        primaryStage.show();
    }
}
