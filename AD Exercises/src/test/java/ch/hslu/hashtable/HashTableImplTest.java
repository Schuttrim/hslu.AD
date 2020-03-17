package ch.hslu.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableImplTest {
    @Test
    void AddAndHasTest() {
        HashTable<FancyInteger> table = new HashTableImpl<>();
        assertFalse(table.has(new FancyInteger(5)));

        table.add(new FancyInteger(5));

        assertTrue(table.has(new FancyInteger(5)));
    }

    @Test
    void SearchTestDoesntContain() {
        HashTable<FancyInteger> table = new HashTableImpl<>();
        table.add(new FancyInteger(3));

        assertNull(table.search(new FancyInteger(5)));
    }

    @Test
    void SearchTestContains() {
        HashTable<FancyInteger> table = new HashTableImpl<>();
        table.add(new FancyInteger(3));

        assertNotNull(table.search(new FancyInteger(3)));
    }

    @Test
    void RemoveTest() {
        HashTable<FancyInteger> table = new HashTableImpl<>();
        assertFalse(table.has(new FancyInteger(5)));
        table.add(new FancyInteger(5));
        assertTrue(table.has(new FancyInteger(5)));

        table.remove(new FancyInteger(5));

        assertFalse(table.has(new FancyInteger(5)));
    }
}