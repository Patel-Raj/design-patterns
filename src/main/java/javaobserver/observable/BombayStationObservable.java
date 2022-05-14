package javaobserver.observable;

import java.util.Observable;

/*
1. This is java's inbuild Observer class.
2. It has many limitations.
3. We need to extend Observable class, which is not a good idea. Ideally implementing an interface is a good idea.
 */
public class BombayStationObservable extends Observable {
    public void weatherUpdate() {
        setChanged();
        notifyObservers();
    }
}
