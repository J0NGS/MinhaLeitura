package Utils.ED;

public interface LinkedListInterface <T> {
    void addFirst(T value);
    void addLast(T value);
    void addAfter(T entity, T ord);
    
    T peekFirst();
    T peekLast();
    
    T search(T ord);
    
    T removeFirst();
    T removeLast();
    T remove(T ord); 
    
	void show();
}
