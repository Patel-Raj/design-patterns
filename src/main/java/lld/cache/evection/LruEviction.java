package lld.cache.evection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import java.util.TreeSet;

public class LruEviction<Key> implements EvictionPolicy<Key> {

    Set<Key> keys;
    Deque<Key> lru;

    public LruEviction() {
        keys = new TreeSet<>();
        lru = new ArrayDeque<>();
    }

    @Override
    public Key evict() {
        Key removedKey = null;
        if(lru.size() > 0) {
            removedKey = lru.removeFirst();
            keys.remove(removedKey);
        }
        return removedKey;
    }

    @Override
    public void keyAccessed(Key key) {
        if(keys.contains(key)) {
            lru.remove(key);
        } else {
            keys.add(key);
        }
        lru.addLast(key);
    }
}
