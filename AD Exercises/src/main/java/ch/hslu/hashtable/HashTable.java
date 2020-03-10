package ch.hslu.hashtable;

public interface HashTable<T> {
    T Search(T value);
    boolean Has(T add);
    void Add(T value);
    void Remove(T value);
}
