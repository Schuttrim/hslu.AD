package ch.hslu.hashtable;

public final class HashTableImpl<T> implements HashTable<T> {
    private final int size;

    public HashTableImpl() {
        this(10);
    }
    public HashTableImpl(int size) {
        this.size = size;
    }

    @Override
    public T Search(T value) {
        return null;
    }

    @Override
    public boolean Has(T add) {
        return false;
    }

    @Override
    public void Add(T value) {

    }

    @Override
    public void Remove(T value) {

    }
}
