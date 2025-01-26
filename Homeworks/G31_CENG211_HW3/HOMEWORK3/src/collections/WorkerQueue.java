package collections;

/**
 *
 * @author Gökay Gülsoy
 */
public class WorkerQueue<T> implements QueueInterface<T> {

    private Node firstNode; // References node at front of queue
    private Node lastNode; // References node at back of queue

    public WorkerQueue() {
        firstNode = null;
        lastNode = null;
    }

    private class Node {

        private T data; // Entry in queue
        private Node next; // Link to next node

        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        // getters for Node inner class
        public T getData() {
            return data;
        }

        public Node getNextNode() {
            return next;
        }

        // setters for Node inner class
        public void setData(T newData) {
            data = newData;
        }

        public void setNextNode(Node nextNode) {
            next = nextNode;
        }

    }

    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
        }

        lastNode = newNode;
    }

    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            return firstNode.getData();
        }
    }

    public T dequeue() {
        T front = getFront(); // might throw EmptyQueueException
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();

        if (firstNode == null) {
            lastNode = null;
        }

        return front;
    }

    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
    }

}
