package Utils.ED;

import java.io.Serializable;

public class Node <T> implements Serializable{
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
