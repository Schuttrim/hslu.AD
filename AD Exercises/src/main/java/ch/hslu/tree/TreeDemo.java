package ch.hslu.tree;

import ch.hslu.memory.Allocation;
import com.sun.source.util.Trees;

import java.util.Iterator;

public class TreeDemo {
    public static void main(final String[] args){
        IntegerSetDemo();

        //AllocationDemo();


    }

    private static void AllocationDemo() {
        Tree<Allocation> allocationTree = TreeSet.Create(((o1, o2) -> o1.getSize() - o2.getSize()));

        Allocation alloc1 = new Allocation(0, 15);
        Allocation alloc2 = new Allocation(0, 4);
        Allocation alloc3 = new Allocation(0, 100);
        Allocation alloc4 = new Allocation(0, 11);
        Allocation alloc5 = new Allocation(0, 23);

        allocationTree.add(alloc1);
        allocationTree.add(alloc2);
        allocationTree.add(alloc3);
        allocationTree.add(alloc4);
        allocationTree.add(alloc5);

        Iterator<Allocation> iterator = allocationTree.inorder();
        while (iterator.hasNext()){
            Allocation alloc = iterator.next();
            System.out.println(alloc.getSize());
        }
    }

    private static void IntegerSetDemo() {
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

        intTree.remove(4);
        iterator = intTree.inorder();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
