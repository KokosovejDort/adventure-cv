package cz.vse.java.dudt05.adventuracv.gui;

import cz.vse.java.dudt05.adventuracv.logika.HerniPlan;
import cz.vse.java.dudt05.adventuracv.logika.Prostor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class PanelVychodu {
    final HerniPlan gamePlan;
    ListView<String> listView = new ListView<>();
    ObservableList<String> vychody = FXCollections.observableArrayList();

    public PanelVychodu(HerniPlan gamePlan) {
        this.gamePlan = gamePlan;

        for (Prostor prostor : gamePlan.getAktualniProstor().getVychody()) {
            vychody.add(prostor.getNazev());
        }

        listView.setItems(vychody);
        listView.setPrefWidth(100);
    }

    public ListView<String> getListView() {
        return listView;
    }
}
