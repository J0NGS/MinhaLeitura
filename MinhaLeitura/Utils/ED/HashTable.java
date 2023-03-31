/*Classe que representa uma HashTable de memória dinâmica*/

package Utils.ED;

import java.io.Serializable;
import java.util.Arrays;

import Utils.ED.Exceptions.HashTableException;

public class HashTable<K,V> implements HashTableInterface<K,V>, Serializable{
    private EntryMap<K,V>[] entries;
    private int size;
    private int capacity;

    public HashTable(){
        this.capacity = 20;
        this.entries = new EntryMap[capacity];
        this.size = 0;
    }

    public HashTable(int capacity){
        this.capacity = capacity;
        this.entries = new EntryMap[this.capacity];
        this.size = 0;
    }
    @Override
    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = Math.abs(hash) % entries.length;

        while(entries[index] != null){
            if(entries[index].getKey().equals(key)){
                entries[index].setValue(value);
            }
            index = (index + 1) % entries.length;
        }

        entries[index] = new EntryMap<K,V>(key, value);
        size++;

        if((double) size / entries.length >= 0.75){
            resize();
        }
    }

    @Override
    public V get(K key) {
        int hash = key.hashCode();
        int index = Math.abs(hash) % entries.length;
        try {
            while(entries[index] != null){
                if(entries[index].getKey().equals(key)){
                    return entries[index].getValue();
                }
                index = (index + 1) % entries.length;
            }
            throw new HashTableException("Não encontrado nenhum valor para essa chave"); 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

    @Override
    public void remove(K key) {
        int hash = key.hashCode();
        int index = Math.abs(hash) % entries.length;

        while (entries[index] != null) {
            if (entries[index].getKey().equals(key)) {
                entries[index] = null;
                size--;
                return;
            }
            index = (index + 1) % entries.length;
        }

        throw new HashTableException("Chave não encontrada");
    }

    @Override
    public boolean containsKey(K key) {
        int hash = key.hashCode();
        int index = Math.abs(hash) % entries.length;

        while (entries[index] != null) {
            if (entries[index].getKey().equals(key)) {
                return true;
            }
            index = (index + 1) % entries.length;
        }

        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null && entries[i].getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void resize() {
        int newCapacity = capacity + 20;
        EntryMap<K, V>[] newTable = new EntryMap[newCapacity];
        for (EntryMap<K, V> entry : entries) {
            if (entry != null) {
                int index = Math.abs(entry.getKey().hashCode()) % newCapacity;
                while (newTable[index] != null) {
                    index = (index + 1) % newCapacity;
                }
                newTable[index] = entry;
            }
        }
        this.entries = newTable;
        this.capacity = newCapacity;
    }

    public void clear() {
        Arrays.fill(entries, null);
        size = 0;
    }

}
