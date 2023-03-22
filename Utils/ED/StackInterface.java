package Utils.ED;

public interface StackInterface <T>{
    void push(T entity);

    T pop();                    //
    T peek();

    boolean isEmpty();
    boolean isFull();

    void show();
}
