package javaobserver.observers;

import javaobserver.observable.BombayStationObservable;

import java.util.Observable;
import java.util.Observer;

public class SamsungObserver implements Observer {
    BombayStationObservable observable;

    public SamsungObserver(BombayStationObservable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Java Samsung updated");
    }
}
