package cz.vse.java.dudt05.adventuracv.main;

import cz.vse.java.dudt05.adventuracv.gui.BagPannel;
import cz.vse.java.dudt05.adventuracv.gui.HerniPlocha;
import cz.vse.java.dudt05.adventuracv.gui.PanelVychodu;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AdventuraZaklad extends Application {

    private final IHra hra = Hra.getSingletone();

    public static void main(String[] args) {
        if (args.length == 0) {
            launch(args);
        }
        else {
            if(args[0].equals("-text")) {
                IHra hra = Hra.getSingletone();
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

    private TextField getReadyInputField(BorderPane borderPane, TextField userInput) {
        Label inputLabel = new Label("Enter command: ");

        HBox inputArea = new HBox();
        inputArea.setPadding(new Insets(5, 0, 5, 0));
        inputArea.getChildren().addAll(inputLabel, userInput);
        inputArea.setAlignment(Pos.CENTER);
        inputArea.setSpacing(10);
        borderPane.setBottom(inputArea);

        return userInput;
    }

    private TextArea getReadyStartScreen(BorderPane borderPane) {
        TextArea textArea = new TextArea();
        borderPane.setCenter(textArea);
        textArea.setText(hra.vratUvitani());
        textArea.setEditable(false);
        return textArea;
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        HerniPlocha gameMap = new HerniPlocha(hra.getHerniPlan());
        borderPane.setTop(gameMap.getAnchorPane());

        PanelVychodu panelVychodu = new PanelVychodu(hra.getHerniPlan());
        ListView<String> listView = panelVychodu.getListView();
        borderPane.setRight(listView);

        BagPannel bagPannel = new BagPannel(hra);
        borderPane.setLeft(bagPannel.getPannel());

        TextArea textArea = getReadyStartScreen(borderPane);

        TextField inputField = new TextField();
        getReadyInputField(borderPane, inputField);
        inputField.setOnAction(actionEvent -> {
            String command = inputField.getText();
            String gameOutput = hra.zpracujPrikaz(command);
            textArea.appendText("\n"+gameOutput);

            inputField.clear();
        });

        Scene scene = new Scene(borderPane);
        inputField.requestFocus();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Adventura");
        primaryStage.show();
    }
}
