package ch.hslu.tree.inorder;

import ch.hslu.tree.Node;

import java.util.Iterator;
import java.util.Stack;

public class InorderIterator<T> implements Iterator<T> {

    private Stack<StackElement<T>> parentNodes = new Stack<>();
    private StackElement<T> current = null;

    public InorderIterator(Node<T> root) {
        if (root != null){
            this.current = new StackElement<T>(root);
            setNext();
        }
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T returnValue = this.current.getNode().getValue();
        this.current.setStatus(InorderStatus.RETURN);
        this.setNext();
        return returnValue;
    }

    private void setNext() {
        if (this.current.getStatus() == InorderStatus.LEFT ){
            while (this.current.getNode().getLeftNode() != null){
                StackElement element = new StackElement(this.current.getNode().getLeftNode());
                //this.current.setStatus(InorderStatus.RETURN);
                this.parentNodes.push(this.current);
                this.current = element;
            }
        }

        if (this.current.getStatus() == InorderStatus.RETURN) {
            if (this.current.getNode().getRightNode() != null) {
                StackElement<T> element = new StackElement<T>(this.current.getNode().getRightNode());
                this.parentNodes.push(this.current);
                this.current = element;
                this.setNext();
            }
            else {
                while (this.current.getStatus() == InorderStatus.RETURN && !this.parentNodes.empty()){
                    this.current = this.parentNodes.pop();
                }
                if (this.current.getStatus() == InorderStatus.RETURN) {
                    this.current = null;
                }
            }
        }

    }
}
