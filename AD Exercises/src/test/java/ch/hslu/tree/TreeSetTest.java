package ch.hslu.tree;

import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;
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

    @Test
    void RemoveRoot() {
        Tree<Integer> tree = TreeSet.Create();
        tree.add(5);

        tree.remove(5);


        assertFalse(tree.has(5));
    }

    @Test
    void RemoveLeaf() {
        Tree<Integer> tree = TreeSet.Create();
        tree.add(5);
        tree.add(6);
        tree.add(2);
        tree.add(3);
        tree.add(4);

        tree.remove(4);

        assertTrue(tree.has(2));
        assertTrue(tree.has(5));
        assertTrue(tree.has(6));
        assertTrue(tree.has(3));
        assertFalse(tree.has(4));
    }

    @Test
    void RemoveItemWithTwoChilds() {
        Tree<Integer> tree = TreeSet.Create();
        tree.add(5);
        tree.add(6);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(1);

        tree.remove(2);

        assertFalse(tree.has(2));
        assertTrue(tree.has(5));
        assertTrue(tree.has(6));
        assertTrue(tree.has(3));
        assertTrue(tree.has(4));
        assertTrue(tree.has(1));
    }


    @Test
    void RemoveRootWithChilds() {
        Tree<Integer> tree = TreeSet.Create();
        tree.add(5);
        tree.add(6);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(7);

        tree.remove(5);

        assertFalse(tree.has(5));
        assertTrue(tree.has(2));
        assertTrue(tree.has(6));
        assertTrue(tree.has(3));
        assertTrue(tree.has(4));
        assertTrue(tree.has(7));
    }

    @Test
    void RemoveItemWithOneChild() {
        Tree<Integer> tree = TreeSet.Create();
        tree.add(5);
        tree.add(6);
        tree.add(2);
        tree.add(3);
        tree.add(4);

        tree.remove(2);

        assertFalse(tree.has(2));
        assertTrue(tree.has(5));
        assertTrue(tree.has(6));
        assertTrue(tree.has(3));
        assertTrue(tree.has(4));
    }
}