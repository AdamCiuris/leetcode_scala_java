
/*
* Adam Ciuris
* better to just do this with locks
*
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {
    private LinkedList<Integer> queue;
    private ReentrantLock lock = new ReentrantLock();
    private Semaphore enqSemaphore;
    private Semaphore deqSemaphore;
    private int size;

    private int capacity;
    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.enqSemaphore = new Semaphore(capacity);
        this.deqSemaphore = new Semaphore(capacity);
        this.deqSemaphore.tryAcquire(capacity);
        queue = new LinkedList<Integer>();
    }

    public void enqueue(int element) throws InterruptedException {
        try {
            while(!enqSemaphore.tryAcquire()) {
                // sleeps until an enqSemaphore spot becomes available
            }
            queue.add(element);
        } finally {
            deqSemaphore.release();
        }
    }

    public int dequeue() throws InterruptedException {
        try {
            while(!deqSemaphore.tryAcquire()) {
                // sleeps until a deqSemaphore spot becomes available
            }
            int res = queue.remove();
            return res; // returns then runs finally block
        } finally {
            enqSemaphore.release();
        }
    }

    public int size() throws InterruptedException {
        synchronized (queue) {
            return queue.size();
        }

    }
}
