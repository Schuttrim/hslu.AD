package ch.hslu.tree;

import ch.hslu.tree.inorder.InorderIterator;

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

    private Node<T> getParent(Node<T> current, T value){
        if (current.isLeaf()) {
            return null; // Begin on Leaf -> no Parent
        }
        int result = this.compareInOrder(value, current);
        Node<T> next;
        if (result < 0){
            next = current.getLeftNode();
        } else if (result > 0) {
            next = current.getRightNode();
        } else {
            return null; // and again no parent
        }

        if (this.compareInOrder(value, next) == 0) {
            return current; // this is the parent
        }
        return getParent(next, value);
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
        Node<T> parent = this.getParent(this.root, value);
        if (parent == null) {
            if (root.isLeaf()) {
                this.root = null;
                return;
            }
        }
        Node<T> delItem = this.root;
        if (parent != null) {
            int comparison = compareInOrder(value, parent);
            if (comparison == 0) {
                throw new InternalError("Error in getParent() Method");
            }
            delItem = comparison > 0 ? parent.getRightNode() : parent.getLeftNode();

            if (delItem.isLeaf()){ // delete the according child
                if(comparison > 0) {
                    parent.setRightNode(null);
                }
                else {
                    parent.setLeftNode(null);
                }
                return;
            }
        }

        if ((delItem.getRightNode() == null) != (delItem.getLeftNode() == null)) { // only one child
            Node<T> onlyChild = delItem.getRightNode() != null ? delItem.getRightNode() : delItem.getLeftNode();
            RerouteChildToParent(value, (Node<T>) parent, (Node<T>) onlyChild);
        } else { // two childs
            if (parent == null){
                Node<T> leftmostRight = delItem.getRightNode();
                while (leftmostRight.getLeftNode() != null){
                    leftmostRight = leftmostRight.getLeftNode();
                }
                leftmostRight.setLeftNode(delItem.getLeftNode());
                this.root = delItem.getRightNode();
            } else {
                InorderIterator<T> iterator = new InorderIterator<>(this.root);
                Node<T> iteratingNode = null;
                while (iterator.hasNext() && iteratingNode != delItem){
                    iteratingNode = iterator.nextNode();
                }
                if (!iterator.hasNext()){
                    throw new InternalError("Sequence should always have next at this point.");
                }
                Node<T> nextInorder = iterator.nextNode();
                Node<T> nextInordersParent = this.getParent(root, nextInorder.getValue());

                if (nextInordersParent != delItem) {
                    nextInordersParent.setLeftNode(nextInorder.getRightNode());
                    RerouteChildToParent(value, (Node<T>) parent, (Node<T>) nextInorder);
                    nextInorder.setLeftNode(delItem.getLeftNode());
                    nextInorder.setRightNode(delItem.getRightNode());
                } else {
                    Node<T> delItemParentParent = getParent(root, parent.getValue());
                    Node<T> nextInorderRightMost = nextInorder.getRightNode();
                    if (nextInorderRightMost != null){
                        while (nextInorderRightMost.getRightNode() != null){
                            nextInorderRightMost = nextInorderRightMost.getRightNode();
                        }
                        nextInorderRightMost.setRightNode(parent);
                    } else {
                        nextInorder.setRightNode(parent);
                    }
                    parent.setLeftNode(null);

                    Node<T> nextInorderLeftMost = nextInorder.getLeftNode();
                    if (nextInorderLeftMost != null) {
                        while (nextInorderLeftMost.getLeftNode() != null) {
                            nextInorderLeftMost = nextInorderLeftMost.getLeftNode();
                        }
                        nextInorderLeftMost.setLeftNode(delItem.getLeftNode());
                    } else {
                        nextInorder.setLeftNode(delItem.getLeftNode());
                    }

                    if (delItemParentParent != null){
                        RerouteChildToParent(nextInorder.getValue(), delItemParentParent, nextInorder);
                    } else {
                        this.root = nextInorder;
                    }
                }
            }
        }

    }

    private void RerouteChildToParent(T value, Node<T> parent, Node<T> child) {
        if (parent != null){
            int comparison = compareInOrder(value, parent);
            if (comparison == 0) {
                throw new InternalError("Error in getParent() Method");
            }
            if (comparison > 0) {
                parent.setRightNode(child);
            } else {
                parent.setLeftNode(child);
            }
        } else {
            this.root = child;
        }
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
