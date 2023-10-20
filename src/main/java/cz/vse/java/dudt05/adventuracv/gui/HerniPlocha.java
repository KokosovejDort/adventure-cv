package cz.vse.java.dudt05.adventuracv.gui;

import cz.vse.java.dudt05.adventuracv.logika.HerniPlan;
import cz.vse.java.dudt05.adventuracv.util.Observer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Objects;

public class HerniPlocha implements Observer {
    private AnchorPane anchorPane = new AnchorPane();
    private Circle point = new Circle(10.0, Paint.valueOf("RED"));
    private HerniPlan gamePlan;
    private ImageView imageView;

    private void setPlayerPosition(HerniPlan gamePlan) {
        AnchorPane.setTopAnchor(point, gamePlan.getAktualniProstor().getPosTop());
        AnchorPane.setLeftAnchor(point, gamePlan.getAktualniProstor().getPosLeft());
    }

    public HerniPlocha(HerniPlan gamePlan) {
        this.gamePlan = gamePlan;

        init();
    }
    private void init() {
        Image image = new Image(Objects.requireNonNull(HerniPlocha.class.getResourceAsStream
                ("/cz.vse.java.xvalm00.adventuracv/herniPlan.png")),
                400, 250,false, false);
        imageView = new ImageView(image);
        gamePlan.registerObserver(this);
        setPlayerPosition(gamePlan);
        anchorPane.getChildren().addAll(imageView, point);
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
    @Override
    public void update() {
        setPlayerPosition(gamePlan);
    }
}
