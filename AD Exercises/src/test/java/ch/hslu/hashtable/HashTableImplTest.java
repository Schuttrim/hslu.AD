package ch.hslu.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableImplTest {
    @Test
    void AddTest() {
        HashTable<FancyInteger> table = new HashTableImpl<>();
        assertFalse(table.has(new FancyInteger(5)));

        table.add(new FancyInteger(5));

        assertTrue(table.has(new FancyInteger(5)));
    }
}