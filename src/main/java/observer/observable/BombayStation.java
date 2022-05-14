package observer.observable;

import observer.observers.DisplayObserver;

import java.util.ArrayList;
import java.util.List;

public class BombayStation implements WeatherStationObservable {

    List<DisplayObserver> observers;

    public BombayStation() {
        observers = new ArrayList<>();
    }

    @Override
    public void addStation(DisplayObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeStation(DisplayObserver observer) {
        int i = observers.indexOf(observer);
        if(i >=0)   observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(DisplayObserver observer : observers) {
            observer.update();
        }
    }

    public void weatherChanged() {
        notifyObservers();
    }
}
