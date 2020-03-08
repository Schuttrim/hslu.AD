package ch.hslu.tree;

import java.util.Iterator;

public interface Tree<T> {
    void add(T value);
    void remove(T value);
    boolean has(T value);
    Iterator<T> inorder();
}
