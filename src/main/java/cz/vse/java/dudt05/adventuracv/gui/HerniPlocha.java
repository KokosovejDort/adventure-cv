package cz.vse.java.dudt05.adventuracv.gui;

import cz.vse.java.dudt05.adventuracv.logika.HerniPlan;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Objects;

public class HerniPlocha {
    private AnchorPane anchorPane = new AnchorPane();
    private Circle point = new Circle(10.0, Paint.valueOf("RED"));
    private HerniPlan gamePlan;
    private ImageView imageView;

    public HerniPlocha(HerniPlan gamePlan) {
        this.gamePlan = gamePlan;
        Image image = new Image(Objects.requireNonNull(HerniPlocha.class.getResourceAsStream
                ("/cz.vse.java.xvalm00.adventuracv/herniPlan.png")),
                400, 250,false, false);
        imageView = new ImageView(image);

        AnchorPane.setTopAnchor(point, 200.0);
        AnchorPane.setLeftAnchor(point, 250.0);
        anchorPane.getChildren().addAll(imageView, point);
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
}
