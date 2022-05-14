package lld.cache.storage;

import java.util.HashMap;
import java.util.Map;

public class MapStorage<Key, Value> implements Storage<Key, Value> {

    Map<Key, Value> map;
    int maxCapacity;

    public MapStorage(int maxCapacity) {
        map = new HashMap<>();
        this.maxCapacity = maxCapacity;
    }


    @Override
    public void add(Key key, Value value) {
        map.put(key, value);
    }

    @Override
    public void remove(Key key) {
        map.remove(key);
    }

    @Override
    public Value get(Key key) {
        return map.get(key);
    }

    @Override
    public boolean isFull() {
        return map.size() >= maxCapacity;
    }
}
