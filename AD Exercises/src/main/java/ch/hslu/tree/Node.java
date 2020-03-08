package ch.hslu.tree;

public class Node<T> {
    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    private Node leftNode;

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    private Node rightNode;

    public T getValue() {
        return value;
    }

    private T value;

    public Node(T value) {
        this.value = value;
    }
}
