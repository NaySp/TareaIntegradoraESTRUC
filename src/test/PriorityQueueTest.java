package test;

import static org.junit.jupiter.api.Assertions.*;
import data_structure.model.PriorityQueue;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class PriorityQueueTest {

    @Test
    public void testInsert() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.insert(3);
        pq.insert(1);
        pq.insert(4);
        pq.insert(2);
        pq.insert(5);

        assertEquals(5, pq.delete().intValue());
        assertEquals(4, pq.delete().intValue());
        assertEquals(3, pq.delete().intValue());
        assertEquals(2, pq.delete().intValue());
        assertEquals(1, pq.delete().intValue());
    }

    @Test
    public void testDelete() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.insert(3);
        pq.insert(1);

        assertEquals(3, pq.delete().intValue());
        assertEquals(1, pq.delete().intValue());

        pq.insert(4);
        assertEquals(4, pq.delete().intValue());
    }

    @Test
    public void testIsEmpty() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        assertTrue(pq.isEmpty());

        pq.insert(1);
        assertFalse(pq.isEmpty());
    }


}
