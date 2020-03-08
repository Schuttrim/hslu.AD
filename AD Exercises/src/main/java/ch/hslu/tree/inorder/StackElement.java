package ch.hslu.tree.inorder;

import ch.hslu.tree.Node;

public class StackElement<T> {
    public Node<T> getNode() {
        return node;
    }

    private Node<T> node;

    public InorderStatus getStatus() {
        return status;
    }

    public void setStatus(InorderStatus status) {
        this.status = status;
    }

    private InorderStatus status = InorderStatus.LEFT;

    public StackElement(Node<T> node) {
        this.node = node;
    }
}
