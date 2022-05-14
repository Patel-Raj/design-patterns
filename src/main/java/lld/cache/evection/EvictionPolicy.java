package lld.cache.evection;

public interface EvictionPolicy<Key> {
    Key evict();

    void keyAccessed(Key key);
}