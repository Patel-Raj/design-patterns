package lld.cache;

import lld.cache.evection.EvictionPolicy;
import lld.cache.storage.Storage;

public class LruCache<Key, Value> implements Cache<Key, Value> {

    Storage<Key, Value> storage;
    EvictionPolicy<Key> evictionPolicy;

    public LruCache(Storage<Key,Value> storage, EvictionPolicy<Key> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public Value get(Key key) {
        Value value = storage.get(key);
        if(value != null) {
            evictionPolicy.keyAccessed(key);
        }
        return value;
    }

    @Override
    public void put(Key key, Value value) {

        if(storage.isFull()) {
            Key removedKey = evictionPolicy.evict();
            storage.remove(removedKey);
        }
        storage.add(key, value);
        evictionPolicy.keyAccessed(key);
    }
}