package ch.hslu.tree;

import com.sun.source.util.Trees;

import java.util.Iterator;

public class TreeDemo {
    public static void main(final String[] args){
        Tree<Integer> intTree = TreeSet.Create();
        intTree.add(10);
        intTree.add(4);
        intTree.add(9);
        intTree.add(5);
        intTree.add(15);
        intTree.add(11);
        intTree.add(6);
        intTree.add(1);
        intTree.add(12);
        intTree.add(15); // duplicate

        Iterator<Integer> iterator = intTree.inorder();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
