package ch.hslu.tree;

import jdk.jshell.spi.ExecutionControl;

import java.util.Comparator;
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

    private Comparator<T> comparator;

    private TreeSet(Comparator<T> comparator){
        this.comparator = comparator;
    }

    public static <T extends Comparable<T>> Tree<T> Create(){
        Comparator<T> comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        };
        return new TreeSet(comp);
    }

    public static <T> Tree<T> CreateSortedByHashcode(){
        Comparator<T> comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.hashCode() - o2.hashCode();
            }
        };
        return new TreeSet(comp);
    }

    public static <T> Tree<T> Create(Comparator<T> comparator){
        return new TreeSet(comparator);
    }
}
