package observer.observable;

import observer.observers.DisplayObserver;

/*
Observer pattern:
1. Observable is responsible for notifying all the observers whenever there is a change in state.
2. Observers register themselves to the observable from which they want to receive updates.
3. This patter saves observers from continually checking whether something has changed or not. They will be automatically notified if something is changed.
 */
public interface WeatherStationObservable {
    void addStation(DisplayObserver observer);
    void removeStation(DisplayObserver observer);
    void notifyObservers();
}
