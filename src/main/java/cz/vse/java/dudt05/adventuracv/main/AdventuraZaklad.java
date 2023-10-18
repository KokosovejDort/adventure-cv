package cz.vse.java.dudt05.adventuracv.main;

import cz.vse.java.dudt05.adventuracv.gui.HerniPlocha;
import cz.vse.java.dudt05.adventuracv.logika.Hra;
import cz.vse.java.dudt05.adventuracv.logika.IHra;
import cz.vse.java.dudt05.adventuracv.uiText.TextoveRozhrani;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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

    private HBox getReadyTextField(BorderPane borderPane, TextArea textArea) {
        TextField userInput = new TextField();
        Label inputLabel = new Label("Enter command: ");

        HBox inputArea = new HBox();
        inputArea.setPadding(new Insets(5, 0, 5, 0));
        inputArea.getChildren().addAll(inputLabel, userInput);
        inputArea.setAlignment(Pos.CENTER);
        inputArea.setSpacing(10);
        borderPane.setBottom(inputArea);
        userInput.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String command = userInput.getText();
                String gameOutput = hra.zpracujPrikaz(command);
                textArea.appendText("\n"+gameOutput);

                userInput.clear();
            }
        });
        return inputArea;
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        HerniPlocha gameMap = new HerniPlocha(hra.getHerniPlan());
        borderPane.setTop(gameMap.getAnchorPane());

        TextArea textArea = new TextArea();
        borderPane.setCenter(textArea);
        textArea.setText(hra.vratUvitani());
        textArea.setEditable(false);

        HBox userInput = getReadyTextField(borderPane, textArea);
        Scene scene = new Scene(borderPane);
        userInput.requestFocus();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Adventura");
        primaryStage.show();
    }
}
