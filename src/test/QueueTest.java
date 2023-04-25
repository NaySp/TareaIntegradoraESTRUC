package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import data_structure.model.Queue;
import org.junit.Assert;



public class QueueTest {

    @Test
    public void testEnqueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        assertFalse(queue.isEmpty());
        assertEquals(10, (int)queue.peek());
    }



    @Test
    public void testDequeue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        int firstElement = queue.dequeue();
        Assert.assertEquals(1, firstElement);
        Assert.assertEquals(2, queue.peek().intValue());
    }


    @Test
    public void testPeek() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        Assert.assertEquals(1, queue.peek().intValue());
    }

    @Test
    public void testIsEmpty() {
        Queue<Integer> queue = new Queue<>();
        Assert.assertTrue(queue.isEmpty());
        queue.enqueue(1);
        Assert.assertFalse(queue.isEmpty());
        queue.dequeue();
        Assert.assertTrue(queue.isEmpty());
    }
}
