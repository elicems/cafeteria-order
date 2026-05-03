package queue;

public interface TAD_Queue {
    public boolean isEmpty();
    public Object enqueue(Object o);
    public Object dequeue();
    public Object peek();
    public String toString();
}
