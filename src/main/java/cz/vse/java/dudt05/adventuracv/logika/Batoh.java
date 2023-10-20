package cz.vse.java.dudt05.adventuracv.logika;

import cz.vse.java.dudt05.adventuracv.util.Observer;
import cz.vse.java.dudt05.adventuracv.util.SubjectOfChange;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 *  Trida Batoh 
 *
 *
 *@author     Alena Buchalcevova
 *@version    z kurzu 4IT101 pro školní rok 2014/2015
 */

public class Batoh implements SubjectOfChange
{
public static final int KAPACITA = 3 ;
private Map<String, Vec> seznamVeci ;   // seznam věcí v batohu
    private Set<Observer> observers = new HashSet<>();


    public Batoh () {
seznamVeci = new HashMap<String, Vec>();
}
 /**
     * Vloží věc do batohu
     *
     *@param  vec  instance věci, která se má vložit
     */
   public void vlozVec (Vec vec) {
       seznamVeci.put(vec.getJmeno(),vec);
       notifyObserver();
    }
     /**
     * Vrací řetězec názvů věcí, které jsou v batohu

     *@return            řetězec názvů
     */
    public String nazvyVeci () {
        String nazvy = "věci v batohu: ";
        for (String jmenoVeci : seznamVeci.keySet()){
            	nazvy += jmenoVeci + " ";
        }
        return nazvy;
    }
     /**
     * Hledá věc daného jména a pokud je v batohu, tak ji vrátí a vymaže ze seznamu

     *@param  jmeno   Jméno věci
     *@return            věc nebo
     *                   hodnota null, pokud tam věc daného jména není 
     */
    public Vec vyberVec (String jmeno) {
        Vec nalezenaVec = null;
        if (seznamVeci.containsKey(jmeno)) {
            nalezenaVec = seznamVeci.get(jmeno);
            seznamVeci.remove(jmeno);
        }
        notifyObserver();
        return nalezenaVec;
    }

    public Set<String> getMnozinaVeci() {
        return seznamVeci.keySet();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.notify();
        }
    }

    public Set<String> itemList() {
        return seznamVeci.keySet();
    }
}



