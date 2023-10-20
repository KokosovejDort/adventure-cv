package cz.vse.java.dudt05.adventuracv.util;

public interface SubjectOfChange {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObserver();
}
