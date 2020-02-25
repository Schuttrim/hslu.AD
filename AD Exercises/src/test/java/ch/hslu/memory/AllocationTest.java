package ch.hslu.memory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllocationTest {

    @Test
    void testHashCodeSameAdressAndSizeSameHash() {
        Allocation testee = new Allocation(1234, 35);
        Allocation compare = new Allocation(1234, 35);

        assertEquals(testee.hashCode(), compare.hashCode());
    }

    @Test
    void testHashCodeSameAdressAndOtherSizeDifferentHash() {
        Allocation testee = new Allocation(1234, 35);
        Allocation compare = new Allocation(1234, 34);

        assertNotEquals(testee.hashCode(), compare.hashCode());
    }

    @Test
    void testHashCodeOtherAdressAndSameSizeDifferentHash() {
        Allocation testee = new Allocation(1234, 30);
        Allocation compare = new Allocation(1234334, 30);

        assertNotEquals(testee.hashCode(), compare.hashCode());
    }

    @Test
    void testEqualsSame() {
        Allocation testee = new Allocation(1234, 35);
        Allocation compare = new Allocation(1234, 35);

        assertEquals(testee, compare);
    }

    @Test
    void testEqualsDifferentSize() {
        Allocation testee = new Allocation(1234, 123);
        Allocation compare = new Allocation(1234, 35);

        assertNotEquals(testee, compare);
    }

    @Test
    void testEqualsDifferentAdress() {
        Allocation testee = new Allocation(1234, 123);
        Allocation compare = new Allocation(546345, 123);

        assertNotEquals(testee, compare);
    }

    @Test
    void compareToBigger() {
        Allocation testee = new Allocation(1234, 0);
        Allocation compare = new Allocation(1233, 0);

        int result = testee.compareTo(compare);

        assertEquals(1,result);
    }

    @Test
    void compareToSmaller() {
        Allocation testee = new Allocation(1232, 0);
        Allocation compare = new Allocation(1233, 0);

        int result = testee.compareTo(compare);

        assertEquals(-1,result);
    }

    @Test
    void compareToSame() {
        Allocation testee = new Allocation(1233, 0);
        Allocation compare = new Allocation(1233, 0);

        int result = testee.compareTo(compare);

        assertEquals(0,result);
    }
}