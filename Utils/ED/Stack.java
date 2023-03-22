package Utils.ED;

import Utils.Exceptions.StackException;

public class Stack <T> implements StackInterface<T>{
    int size;
    private Object[] array;
    int top;


    public Stack(int size){
        this.top = -1;                              //inicializando top com -1, quando adicionado o primeiro elemento de indice 0, top = 0
        this.size =  size;
        this.array = new Object[size];
    }

    @Override
    public void push(T entity) {
        try {
            if (top == size-1)
                throw new StackException("Error. full stack");
            
            top = top + 1;
            array[top] = entity;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T pop() {
        
        try {
            T entity;
            if (top == size-1)
                throw new StackException("Error. full stack");

            entity = (T)array[top];
            top = top - 1;
            return entity;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T peek() {
        T entity;
        try {
            if (top == size-1)
                throw new StackException("Error. full stack");
            
            entity = (T)array[top];
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        if(top==-1)
            return true;
        else
            return false;
        
    }

    @Override
    public boolean isFull() {
        if(top==-1)
            return false;
        else
            return true;
    }

    @Override
    public void show() {
        for(int i = 0; i<= top; i++){
            System.out.println("Index: " + i + " = " + array[i] + "/n");
        }
        System.out.println("Top:  = " + array[top] + "/n");
    }f
    
}
