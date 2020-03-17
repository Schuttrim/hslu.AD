package ch.hslu.hashtable;

public interface HashTable<T> {
    T search(T value);
    boolean has(T add);
    void add(T value);
    void remove(T value);
}
