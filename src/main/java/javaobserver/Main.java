package javaobserver;

import javaobserver.observable.BombayStationObservable;
import javaobserver.observers.SamsungObserver;
import javaobserver.observers.SonyObserver;

public class Main {
    public static void main(String args[]) {
        BombayStationObservable observable = new BombayStationObservable();
        SamsungObserver samsungObserver = new SamsungObserver(observable);
        SonyObserver sonyObserver = new SonyObserver(observable);

        observable.weatherUpdate();
    }
}
