package ch.hslu.tree;

import ch.hslu.tree.inorder.InorderIterator;
import jdk.jshell.spi.ExecutionControl;

import java.util.Comparator;
import java.util.Iterator;

public class TreeSet<T> implements Tree<T> {
    @Override
    public void add(T value) {
        if (this.root == null){
            this.root = new Node<T>(value);
            return;
        }

        Node<T> result = this.getParentOrNode(this.root, value);
        int compare = this.compareInOrder(value, result);
        if (compare < 0) {
            result.setLeftNode(new Node<T>(value));
        } else if (compare > 0){
            result.setRightNode(new Node<T>(value));
        }
    }

    private int compareInOrder(T value, Node<T> nodeValue){
        return this.comparator.compare(value, nodeValue.getValue());
    }

    private Node<T> getParentOrNode(Node<T> current, T value){
        if (current.isLeaf())
            return current; // parent or node
        int result = this.compareInOrder(value, current);
        if (result < 0){
            return current.getLeftNode() != null ? this.getParentOrNode(current.getLeftNode(), value) : current; // parent
        } else if (result > 0) {
            return current.getRightNode() != null ? this.getParentOrNode(current.getRightNode(), value) : current; // parent
        } else {
            return current; // node
        }
    }

    @Override
    public void remove(T value) {
        throw new Error("Not Implemented");
    }

    @Override
    public boolean has(T value) {
        if (this.root == null) {
            return false;
        }

        Node<T> result = this.getParentOrNode(this.root, value);
        return this.compareInOrder(value, result) == 0;
    }

    @Override
    public Iterator<T> inorder() {
        return new InorderIterator<T>(this.root);
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
