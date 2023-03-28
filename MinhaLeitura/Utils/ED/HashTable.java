/*Classe que representa uma HashTable de memória dinâmica*/

package Utils.ED;

import java.io.Serializable;

import Utils.Exceptions.HashTableException;

public class HashTable<K,V> implements HashTableInterface<K,V>, Serializable{
    private LinkedListDouble<EntryMap<K, V>> entries;
    private int size;

    public HashTable() {
        entries = new LinkedListDouble<EntryMap<K, V>>();
        size = 0;
    }

    //Adiciona elemento na HashTable
    public void put(K key, V value) {
        //Ponteiro temporario para buscar elemento na lista
        EntryMap<K, V> entry = findEntry(key);

        //Se o elemento não exisitr na lista adiciona um novo
        if (entry == null) {
            entry = new EntryMap<K, V>(key, value);
            entries.addLast(entry);
            size++;
        } 
        //Se o elemento já existir na lista com a mesma key o elemento é atualizado pelo novo
        else {                                                
            entry.setValue(value);
        }
    }

    //Retorna elemento a partir da key informada
    public V get(K key) {
        try {
            //Procura elemento pela chave
            EntryMap<K, V> entry = findEntry(key);
            if(entry != null)
                return entry.getValue();
            else
                throw new HashTableException("Valor não encontrado");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //Remove um elemento a partir da key
    public void remove(K key) {
        try {
            //Procura elemento
            EntryMap<K, V> entry = findEntry(key);
            //Remove da lista    
            entries.remove(entry);
            //Dimiminui o tamano
            size--;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        while (entries.head != null) {
            entries.removeFirst();
            size--;
        }
    }

    public boolean containsKey(K key) {
        return findEntry(key) != null;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % entries.getSize());
    }

    private EntryMap<K, V> findEntry(K key) {
        try {
            //Cria node para começar pela cabeça da lista
            Node<EntryMap<K, V>> node = entries.head;
            //Busca node enquando o node atual for diferente de nulo(enquanto não acabar a lista)
            while (node != null) {
                //se achar o node com a mesma key retorna ele
                if (node.data.getKey().equals(key)) {
                    return node.data;
                }
                //caso não encontre no node atual, muda para o node anterior ao atual
                node = node.next;
            }
            throw new HashTableException("Entrada não encontrada");
        }        
        catch (Exception e) {
            return null;
        }
    }
    
    public int size() {
        return size;
    }

    public boolean containsValue(V value) {
        Node<EntryMap<K, V>> node = entries.head;
        while (node != null) {
            if (node.data.getValue().equals(value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean isEmpty(){
        if(this.size == 0)
            return true;
        else
            return false;
    }


    public LinkedListDouble<EntryMap<K,V>> getEntries() {
        return this.entries;
    }

    public void setEntries(LinkedListDouble<EntryMap<K,V>> entries) {
        this.entries = entries;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
