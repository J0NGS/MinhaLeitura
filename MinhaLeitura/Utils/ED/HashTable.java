/*Classe que representa uma HashTable de memória dinâmica*/

package Utils.ED;

import java.io.Serializable;
import java.util.Arrays;

import Utils.ED.Exceptions.HashTableException;

public class HashTable<K,V> implements HashTableInterface<K,V>, Serializable{
    private final EntryMap<K, V> TOMBSTONE = new EntryMap<>(null, null);    //Tumulo para representar valores que foram retirados       
    private EntryMap<K,V>[] entries;                                                  //Entrada
    private int size;                                                                 //Quantidade de elementos armazenados
    private int capacity;                                                             //Capacidade atual

    // Construtor padrão que cria uma tabela de hash com capacidade inicial de 20
    public HashTable(){
        this.capacity = 20;
        this.entries = new EntryMap[capacity];
        this.size = 0;
    }

    // Construtor que cria uma tabela de hash com a capacidade passada como parâmetro
    public HashTable(int capacity){
        this.capacity = capacity;
        this.entries = new EntryMap[this.capacity];
        this.size = 0;
    }

    
    // Adiciona um novo elemento na tabela
    @Override
    public void put(K key, V value) {
        // Obtém o hash da chave
        int hash = key.hashCode();
        // Calcula o índice da entrada utilizando o hash e a capacidade da tabela
        int index = Math.abs(hash) % entries.length;

        // Percorre a tabela até encontrar uma posição vazia ou uma posição com a mesma chave
        while (entries[index] != null && !entries[index].getKey().equals(key) && !entries[index].getKey().equals(TOMBSTONE)) {
            index = (index + 1) % entries.length;
        }
    
        // Insere o novo par chave-valor na posição encontrada
        entries[index] = new EntryMap<K, V>(key, value);
        size++;
    
        // Verifica se a tabela precisa ser redimensionada
        if ((double) size / entries.length >= 0.75) {
            resize();
        }
    }

    //Obtem o valor a partir da chave informada
    @Override
    public V get(K key) {
        int hash = key.hashCode();                          // Obtém o hash da chave
        int index = Math.abs(hash) % entries.length;        // Calcula o índice da entrada utilizando o hash e a capacidade da tabela
        try {
            // Percorre a tabela até encontrar a entrada correspondente à chave
            while(entries[index] != null){
                if(entries[index].getKey().equals(key)){
                    return entries[index].getValue();       // Retorna o valor associado à chave
                }
                index = (index + 1) % entries.length;
            }
            throw new HashTableException("Não encontrado nenhum valor para essa chave"); // Se não encontrar a chave, lança uma exceção
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Remove o elemento a partir da chave informada
    @Override
    public void remove(K key) {
        int hash = key.hashCode();                      // Calcula o valor hash da chave
        int index = Math.abs(hash) % entries.length;    // Calcula o índice no array onde o valor deve ser armazenado
        int start = index;                              // Guarda o índice de partida para verificar se já percorreu toda a tabela

        // Percorre a tabela até encontrar um valor nulo
        while (entries[index] != null) {

            // Se o valor atual na tabela é o valor buscado, marca como uma tumba
            if (entries[index].getKey().equals(key) && !entries[index].equals(TOMBSTONE)) {
                entries[index] = TOMBSTONE;
                size--;
                return;
            }
            
            index = (index + 1) % entries.length;       // Incrementa o índice, considerando a tabela circular
            if (index == start)                         // Verifica se já percorreu toda a tabela
                break;                  
        }
    
        // Se a chave não foi encontrada, lança uma exceção
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
