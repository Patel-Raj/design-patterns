package observer.observers;

import observer.observable.WeatherStationObservable;

public class SonyObserver implements DisplayObserver{
    WeatherStationObservable observable;

    public SonyObserver(WeatherStationObservable observable) {
        this.observable = observable;
        observable.addStation(this);
    }
    @Override
    public void update() {
        System.out.println("Sony observer called");
    }
}
