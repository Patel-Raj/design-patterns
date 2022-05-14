package lld.cache;

public interface Cache<Key, Value> {
    Value get(Key key);

    void put(Key key, Value value);
}
