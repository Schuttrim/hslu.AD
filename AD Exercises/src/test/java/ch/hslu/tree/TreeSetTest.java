package ch.hslu.tree;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class TreeSetTest {

    @Test
    void EmptySet_HasWorks() {
        Tree<Integer> tree = TreeSet.Create();

        assertFalse(tree.has(1));
    }

    @Test
    void EmptySet_InorderWorks() {
        Tree<Integer> tree = TreeSet.Create();
        Iterator<Integer> iterator = tree.inorder();

        assertFalse(iterator.hasNext());
    }

    @Test
    void AddAndHasConsistent() {
        Tree<Integer> tree = TreeSet.Create();

        assertFalse(tree.has(4));
        tree.add(4);
        assertTrue(tree.has(4));
        tree.add(4);
        tree.add(4);
        assertTrue(tree.has(4));
    }
}