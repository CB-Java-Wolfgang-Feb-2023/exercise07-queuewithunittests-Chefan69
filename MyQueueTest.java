import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MyQueueTest {

    private MyQueue queue;

    @BeforeEach
    void setUp() {
        queue = new MyQueue(5);
    }

    @Test
    void testIsEmptyOnNewQueue() {
        assertTrue(queue.isEmpty(), "New queue should be empty");
    }

    @Test
    void testIsFullOnNewQueue() {
        assertFalse(queue.isFull(), "New queue should not be full");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testEnqueue(int element) {
        queue.enqueue(element);
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueue");
    }

    @Test
    void testDequeueOnEmptyQueue() {
        assertEquals(-1, queue.dequeue(), "Dequeue should return -1 on empty queue");
    }

    @Test
    void testEnqueueAndDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue(), "Dequeue should return the first element");
        assertEquals(2, queue.dequeue(), "Dequeue should return the next element");
        assertTrue(queue.isEmpty(), "Queue should be empty after dequeueing all elements");
    }

    @Test
    void testEnqueueUntilFull() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        assertTrue(queue.isFull(), "Queue should be full after 5 enqueues");
    }

    @Test
    void testEnqueueOnFullQueue() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        queue.enqueue(6);
        assertTrue(queue.isFull(), "Enqueue on full queue should not change its full status");
    }

    @Test
    void testPeekOnEmptyQueue() {
        assertEquals(-1, queue.peek(), "Peek should return -1 on empty queue");
    }

    @Test
    void testPeek() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.peek(), "Peek should return the first element without removing it");
    }
}