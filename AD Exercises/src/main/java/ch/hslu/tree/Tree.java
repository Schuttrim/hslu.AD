package ch.hslu.tree;

import java.util.Iterator;

public interface Tree<T> {
    void add(T item);
    void remove(T item);
    boolean has(T item);
    Iterator<T> inorder();
}
