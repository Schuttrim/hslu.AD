package ch.hslu.hashtable;

public final class HashTableImpl<T> implements HashTable<T> {
    private final int size;
    private Object[] items;

    public HashTableImpl() {
        this(10);
    }

    public HashTableImpl(int size) {
        this.size = size;
        this.items = new Object[this.size];
    }

    @Override
    public T search(T value) {
        int index = this.getIndexFromHash(value.hashCode());
        T item = this.getItemAt(index);
        if (value.equals(item)){
            return item;
        } else {
            return null;
        }
    }

    @Override
    public boolean has(T value) {
        return this.search(value) != null;
    }

    @Override
    public void add(T value) {
        if (!this.tryAdd(value)) {
            throw new Error("Hashcollision");
        }
    }

    @Override
    public void remove(T value) {
        int index = this.getIndexFromHash(value.hashCode());
        T item = this.getItemAt(index);
        if (value.equals(item)){
            setItemAt(index, null);
        }
        else {
            throw new Error("Hashcollision");
        }
    }

    private T getItemAt(int index) {
        return (T)this.items[index];
    }
    private void setItemAt(int index, T item){
        this.items[index] = item;
    }
    private boolean hasItemAt(int index) { return this.items[index] != null; }
    private int getIndexFromHash(int index){
        return Math.abs(index % this.size);
    }
    private boolean tryAdd(T value){
        int hash = value.hashCode();
        int index = this.getIndexFromHash(hash);
        if (hasItemAt(index)){
            return false;
        }
        setItemAt(index, value);
        return true;
    }
}