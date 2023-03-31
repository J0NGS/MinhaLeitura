package Utils.ED;

import java.io.Serializable;

import Utils.ED.Exceptions.ListException;

public class LinkedListDouble <T> implements LinkedListInterface<T>, Serializable{
	// Atributos de MyLinkedListSingly
    public Node<T> head;    
    public Node<T> tail;
	public int size;
    
    // Construtor de MyLinkedListSingly
	public LinkedListDouble() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void show()
	{
	    Node<T> p = head;
	    
		if(p == null)
			throw new ListException("LISTA VAZIA \n");
		else
	    {
	        while( p != null )
	        {
	    	    p = p.next;
	        }
	    }
	}
	
	
	
	public void addFirst(T entity)
	{
		Node<T> newer = new Node<T>(entity);
	    
		// Anexa elemento NOVO (cuidado com a ordem! Dica: comece atribuindo os campos null)
		if(head == null) {
			head = newer;	// novo será o primeiro elemento
			tail = newer;	// novo será o último elemento
		} 
		else {
			// Anexa
			newer.next = head;
			head.prev = newer; // novidade
			head = newer;
		}
		
		size++;
	}
	
	
	
	

	public void addLast(T entity)
	{		 
	    Node<T> newer = new Node<T>(entity);    

	    // verifica se lista está vazia
	    if( head == null ) { 
	        head = newer;       	// novo será o primeiro elemento
	        tail = newer;		// novo será o último elemento
	    }
	    else
	    {
			// Anexa
	    	newer.prev = tail; // novidade. Lembre-se de começar a anexação pelo novo elemento
	    	tail.next = newer;
	        tail = newer;
	    }
	    
	    size++;
	}

	
	
	
	
	public void addAfter(T entity, T ord)
	{
		// Antecessor
	    Node<T> p = searchNode(ord);
        try {
            if( p == null )	// Verifica se o criterio existe
                throw new ListException("Criterio invalido \n");
            else
            {
                // Novo elemento 
                Node<T> newer = new Node<T>(entity);
    
                // Atualiza tail quando o elemento criterio eh o ultimo
                if(p.next == null)
                    tail = newer;
                
                // Anexa (dicas: comece atribuindo os campos null)
                newer.next = p.next;
                newer.prev = p;		// novidade
                p.next = newer;
                
                // novidade
                Node<T> frente = newer.next;	// var auxiliar
                if(frente != null) 		// previne nullpoint quando add no tail
                    frente.prev = newer;
                
                size++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
	public T peekFirst()
	{	try{
		if( head == null ) 
	        throw new ListException("Lista Vazia!!! \n");
		else
			return head.data;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
	}
	
	
	public T peekLast()
	{
        try{
            if( head == null ) 
                throw new ListException("Lista Vazia!!! \n");
            else
                return tail.data;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }
	}
	

	private Node<T> searchNode(T criterio)
	{
	    Node<T> p = head;		// ponteiro temporarip
    /*
     *  OBS: o critério de comparação será aquele 
     *  que foi definido na sua classe-entidade
     *  nos métodos equals() e hashCode().
     *  Se não houver esta definição, um objeto 
     *  será considerado igual se todos os atributos
     *  forem iguais.
     */
    try {
	    while( p != null )                                                          
	    {
	        if( p.data.equals(criterio) ) {                                             
	            return p;
	        }
	        p = p.next;
	    }
        throw new ListException("Node not found");
        
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }

	}

	
	public T search(T criterio)
	{
		Node<T> p = searchNode(criterio);
		
		if(p == null) {
			return null;
		} else {
			return p.data;
		}
	}

	
	
	public T removeFirst()
	{	
        
		Node<T> p = head;
		T dadoRetorno = null;
        try {
            if( head == null )
                throw new ListException("Lista Vazia\n");
            else
            {
                dadoRetorno = p.data;
                
                if (head == tail) 
                {
                    head = null;
                    tail = null;
                } 
                else {
                    head = head.next;
                    head.prev = null; // novidade
                }
                
                p.next = null; // isola elemento removido
                
                size--;
            }
            return dadoRetorno;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	
	public T removeLast() 
	{
        
		Node<T> p = head;
		T dadoRetorno = null;
        try {
            if( head == null )
                throw new ListException("Lista Vazia\n");
            else
            {
                dadoRetorno = p.data;
                
                if (head == tail) 
                {
                    head = null;
                    tail = null;
                } 
                else {
                    Node<T> lastingNode = tail.prev;
                    tail.prev = null;
                    tail = lastingNode;
                    tail.next = null; // novidade
                }
                size--;
            }
            return dadoRetorno;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	
	
	public T remove(T ord)
	{
		T dadoRetorno = null;
        try {
            if( head == null )
                throw new ListException("Lista Vazia\n");
    
            Node<T> lasting = null;
            Node<T> removed = searchNode(ord); // null: criterio nao existe OU criterio esta no 1o elemento
        
            if(removed != null)
                lasting = removed.prev;  // evita nullpointer
            
            // OBS: vc pode usar a referencia de removido para alterar os IFs abaixo,
            // porem, mantive a mesma estrutura usada na lista simples para facilitar.
            
            if( removed == null ) 
            {
                if( head.data.equals(ord) == false )
                    throw new ListException("criterio nao existe!!! \n");
                else
                    return removeFirst();
            }
            else
            {   
                if(removed == tail) 
                    return removeLast();
                else 
                {
                    Node<T> front = removed.next;	// var auxiliar
                    
                    // se desliga do elemento removido
                    lasting.next = front;		
                    front.prev = lasting; // novidade
                    
                    // isola elemento removido
                    removed.next = null;
                    removed.prev = null;  // novidade
                    
                    size--;
                    
                    dadoRetorno = removed.data;
                    return dadoRetorno;
                }
            }   
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
	}

    public int getSize(){
        return this.size;
    }
}
