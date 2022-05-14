package observer.observers;

import observer.observable.WeatherStationObservable;

public class SamsungObserver implements DisplayObserver {
    WeatherStationObservable observable;

    public SamsungObserver(WeatherStationObservable observable) {
        this.observable = observable;
        observable.addStation(this);
    }

    @Override
    public void update() {
        System.out.println("Samsung observer called");
    }
}
