package ch.hslu.tree;

import jdk.jshell.spi.ExecutionControl;

import java.util.Iterator;

public class TreeSet<T> implements Tree<T> {
    @Override
    public void add(T item) {
        throw new Error("Not Implemented");
    }

    @Override
    public void remove(T item) {
        throw new Error("Not Implemented");
    }

    @Override
    public boolean has(T item) {
        throw new Error("Not Implemented");
    }

    @Override
    public Iterator<T> inorder() {
        throw new Error("Not Implemented");
    }
}
