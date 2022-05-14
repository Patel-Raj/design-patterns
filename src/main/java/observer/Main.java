package observer;

import observer.observable.BombayStation;
import observer.observable.WeatherStationObservable;
import observer.observers.DisplayObserver;
import observer.observers.SamsungObserver;
import observer.observers.SonyObserver;

import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) {
        WeatherStationObservable bombayStation = new BombayStation();
        DisplayObserver samsungObserver = new SamsungObserver(bombayStation);
        DisplayObserver sonyObserver = new SonyObserver(bombayStation);

        ((BombayStation) bombayStation).weatherChanged();
        

    }
}
