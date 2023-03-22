package Utils.ED;

import Utils.Exceptions.ListException;

public class LinkedList <T> implements LinkedListInterface <T>{
    private Node<T> head;
    private Node<T> tail;
    public int size;


    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void addFirst(T value) {
       Node<T> newer = new Node<T>(value);
       // Ordenação
       if(head == null){
        head = newer;
        tail = newer;
       }else{
        newer.next = head;
        head = newer;
       }
       size++;
    }

    @Override
    public void addLast(T value) {
        Node<T> newer = new Node<T>(value);
        // Ordenação
        if(head == null){
         head = newer;
         tail = newer;
        }else{
         tail.next = head;
         tail = newer;
        }
        size++;
    }

    @Override
    public void addAfter(T entity, T ord) {
        Node<T> p = searchNode(ord);
        try {
            if(p == null)
                throw new ListException("Criterio inválido");
            else{
                Node<T> newer = new Node<T>(entity);
                //Atualizando tail quando for o ultimo elemento
                if(p.next == null)
                    tail = newer;
                
                newer.next = p.next;
                p.next = newer;
                size++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T peekFirst() {
        try {
            if(head == null)
                throw new ListException("Lista vazia");
            else
                return head.data;
            

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T peekLast() {
        try {
            if(tail == null)
                throw new ListException("Lista vazia");
            else
                return tail.data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }   
    }

    @Override
    public T search(T ord) {
        Node<T> p = searchNode(ord);
        if(p == null)
            return null;
        else
            return p.data;
    }

    @Override
    public T removeFirst() {
        try {
            Node<T> p = head;
            T returnData = null;
            if (head == null) {
                throw new ListException("Lista vazia");
            } else {
                returnData  = head.data;
                if(head == tail){
                    head = null;
                    tail = null;
                }else{
                    head = head.next;
                }
                p.next = null;
                size--;
            }
            return returnData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T removeLast() {
        try {
            T returnData = null;
            if (tail == null) {
                throw new ListException("Lista vazia");
            } else {
                returnData  = tail.data;
                if(head == tail){
                    head = null;
                    tail = null;
                }else{
                    Node<T> p = head;
                    //Buscando penultimo elemento
                    while(p.next != tail){
                        p = p.next;
                    }
                    tail = p;
                    tail.next = null;
                }
                size--;
            }
            return returnData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T remove(T ord) {
        Node<T> lasting = null;
		Node<T> removing = null;

		if( head == null )
            throw new ListException("Lista vazia");

		lasting = searchBefore(ord); // null: ID não existe OU ID está no 1o elemento

		if( lasting == null ) 
		{
			if( head.data.equals(ord) == false )
		        throw new ListException("criterio nao existe!!! \n");
			else
				return removeFirst();
		}
		else
		{   removing = lasting.next;
			if(removing == tail)
				return removeLast();
			else {
				lasting.next = removing.next;	// se desliga do elemento removido
		        removing.next = null;			// isola elemento removido
		        size--;
		        
				return removing.data;
			}
		}
    }

    @Override
    public void show() {
        try {
        Node<T> p = head;
        if(p == null) {
            throw new ListException("LISTA VAZIA \n");
        }
        else {
        while( p != null )
            {
            System.out.println("\n");
            System.out.println("Dado: " + p.data );
            System.out.println("\n");
            p = p.next;
            }
        }
        System.out.println("size = " + size + "\n");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Node<T> searchNode(T ord)
	{
	    Node<T> p = head;		// ponteiro temporario

	    while( p != null )
	    {
	        if( p.data.equals(ord) ) {
	            return p;
	        }
	        p = p.next;
	    }
	    return null;
	}

    private Node<T> searchBefore(T ord)
	{
	    Node<T> p = head; 	   			// ponteiro temporario
		Node<T> lasting = null;	   	// ponteiro anterior

	    while (p != null)
	    {
	    	lasting = p;
	        p = p.next;
	        
	        if (p != null && p.data.equals(ord) ) {
	           return lasting;
	        }
	    }
	    
	    return null;
	}
	

}
