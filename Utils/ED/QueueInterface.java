package Utils.ED;

public interface QueueInterface <T>{
    void add(T entity);
    T remove();
    T peek();

    boolean isEmpty();
    boolean isFull();
}
