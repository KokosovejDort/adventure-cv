package cz.vse.java.dudt05.adventuracv.main;

import cz.vse.java.dudt05.adventuracv.logika.Hra;
import cz.vse.java.dudt05.adventuracv.logika.IHra;
import cz.vse.java.dudt05.adventuracv.uiText.TextoveRozhrani;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AdventuraZaklad extends Application {

    private final IHra hra = new Hra();

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

        TextArea textArea = new TextArea();//Area for output
        borderPane.setCenter(textArea);
        textArea.setText(hra.vratUvitani());
        textArea.setEditable(false);

        TextField userInput = new TextField(); //Area for code
        borderPane.setBottom(userInput);
        userInput.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String command = userInput.getText();
                String gameOutput = hra.zpracujPrikaz(command);
                textArea.appendText("\n"+gameOutput);

                userInput.clear();
            }
        });

        Scene scene = new Scene(borderPane);
        userInput.requestFocus();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
