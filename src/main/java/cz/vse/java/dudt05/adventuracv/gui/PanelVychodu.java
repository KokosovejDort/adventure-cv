package cz.vse.java.dudt05.adventuracv.gui;

import cz.vse.java.dudt05.adventuracv.logika.HerniPlan;
import cz.vse.java.dudt05.adventuracv.logika.Prostor;
import cz.vse.java.dudt05.adventuracv.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class PanelVychodu implements Observer {
    final HerniPlan gamePlan;
    ListView<String> listView = new ListView<>();
    ObservableList<String> vychody = FXCollections.observableArrayList();

    public PanelVychodu(HerniPlan gamePlan) {
        this.gamePlan = gamePlan;

        init();
        gamePlan.registerObserver(this);
    }

    private void init() {
        getCurrentVychody();
        listView.setItems(vychody);
        listView.setPrefWidth(100);
    }

    private void getCurrentVychody() {
        vychody.clear();
        Prostor currentLocation = gamePlan.getAktualniProstor();
        for (Prostor prostor : currentLocation.getVychody()) {
            vychody.add(prostor.getNazev());
        }
    }

    public ListView<String> getListView() {
        return listView;
    }

    @Override
    public void update() {
        getCurrentVychody();
    }
}
