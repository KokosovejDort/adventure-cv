package cz.vse.java.dudt05.adventuracv.gui;

import cz.vse.java.dudt05.adventuracv.logika.Batoh;
import cz.vse.java.dudt05.adventuracv.logika.IHra;
import cz.vse.java.dudt05.adventuracv.util.Observer;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

public class BagPannel implements Observer {

    private VBox vbox = new VBox();
    private final FlowPane itemPanel = new FlowPane();
    private final Batoh bag;

    public BagPannel(IHra hra) {
        bag = hra.getBatoh();
        init();
        bag.registerObserver(this);
    }

    private void init() {
        vbox.setPrefWidth(100);
        Label label = new Label("List of items:");
        vbox.getChildren().addAll(label, itemPanel);
        updateItemsImage();
    }

    public void updateItemsImage() {
        itemPanel.getChildren().clear();
        Set<String> items =  bag.itemList();
        for (String item: items) {
            Label label = new Label(item);
            itemPanel.getChildren().add(label);
        }
    }

    @Override
    public void update() {
        updateItemsImage();
    }

    public Node getPannel() {
        return vbox;
    }
}
