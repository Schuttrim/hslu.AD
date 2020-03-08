package ch.hslu.tree;

import jdk.jshell.spi.ExecutionControl;

import java.util.Comparator;
import java.util.Iterator;

public class TreeSet<T> implements Tree<T> {
    @Override
    public void add(T item) {
        if (this.root == null){
            this.root = new Node<T>(item);
            return;
        }

        Node<T> result = this.getParentOrNode(this.root, item);
        int compare = this.compareInOrder(item, root.getValue());
        if (compare < 0) {
            result.setLeftNode(new Node<T>(item));
        } else if (compare > 0){
            result.setRightNode(new Node<T>(item));
        }
    }

    private int compareInOrder(T value, T nodeValue){
        return this.comparator.compare(value, nodeValue);
    }

    private Node<T> getParentOrNode(Node<T> current, T value){
        if (current.isLeaf())
            return current;
        int result = this.compareInOrder(value, current.getValue());
        if (result < 0){
            return this.getParentOrNode(current.getLeftNode(), value);
        } else if (result > 0) {
            return this.getParentOrNode(current.getRightNode(), value);
        } else {
            return current;
        }
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
    private Node<T> root;

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
