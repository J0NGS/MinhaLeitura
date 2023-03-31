package Utils.ED;

import Utils.ED.Exceptions.QueueException;

public class Queue <T> implements QueueInterface<T>{
    int size;
    private Object[] array;
    int first;
    int last;


    public Queue(int size){
        this.first = -1;
        this.last = -1;
        this.size = size;
        this.array = new Object[size];
    }

    @Override
    public void add(T entity) {
        int aux =  (last + 1) % size;
        try {
            if (aux  == first)
                throw new QueueException("Fila cheia, não foi possivel adicionar o elemento");
            last = aux;
            array[last] = entity;            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T remove() {
        try {
            T aux;
            if(first == -1)
                throw new QueueException("Fila vazia");
            aux = (T) array[first];
            if(first == last){
                first = -1;
                last = -1;
            }else{
                first = (first + 1) % size;
            }
            return aux;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T peek() {
        try {
            T aux;
            if(first == -1)
                throw new QueueException("Fila vazia");
            aux = (T) array[first];
            return aux;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
	    if( first == -1 )
	        return true;
	    else
	    	return false;
    }

    @Override
    public boolean isFull() {
	    if( first == -1 )
	        return false;
	    else
	    	return true;
    }
    
}
