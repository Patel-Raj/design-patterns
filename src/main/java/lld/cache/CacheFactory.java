package lld.cache;

import lld.cache.evection.LruEviction;
import lld.cache.storage.MapStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> getCache() {
        return new LruCache<>(new MapStorage<Key, Value>(5), new LruEviction<Key>());
    }
}
