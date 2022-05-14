package javaobserver.observers;

import javaobserver.observable.BombayStationObservable;

import java.util.Observable;
import java.util.Observer;

public class SonyObserver implements Observer {
    BombayStationObservable observable;

    public SonyObserver(BombayStationObservable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Java Sony updated");
    }
}
