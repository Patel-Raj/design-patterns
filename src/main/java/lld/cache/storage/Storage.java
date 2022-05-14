package lld.cache.storage;

public interface Storage<Key, Value> {
    void add(Key key, Value value);

    void remove(Key key);

    Value get(Key key);

    boolean isFull();
}
