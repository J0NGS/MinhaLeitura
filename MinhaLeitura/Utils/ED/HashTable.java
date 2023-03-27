/*Classe que representa uma HashTable de memória dinâmica*/

package Utils.ED;

import Utils.Exceptions.HashTableException;

public class HashTable<K,V> implements HashTableInterface<K,V>{
    // Atributos da tabela hash
    private LinkedListDouble<EntryMap<K, V>> buckets;           // Elementos armazenados
    private int size;                                           // Quantidade de elementos armazenados
    private int capacity;                                       // Capacidade atual da tabela
    private double loadFactor;                                  // Fator de carga para medir eficiência (elementos/posições)

    // Construtor
    public HashTable() {
        this.capacity = 20;                                     // Capacidade inicial setado em 20
        this.loadFactor = 0.75;                                 // Quanto a lista este 75% irá ocorrer resize
        this.buckets = new LinkedListDouble<EntryMap<K,V>>();   // inicialização da lista
        for (int i = 0; i < capacity; i++) {
            buckets.addFirst(null);
        }
        this.size = 0;
    }

    // Insere um par chave-valor na tabela hash
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        EntryMap<K, V> entry = buckets.get(bucketIndex);

        // Se a chave já existir, atualiza o valor
        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }

        // Cria uma nova entrada e insere no início da lista
        EntryMap<K, V> newEntry = new EntryMap<>(key, value);
        newEntry.next = buckets.get(bucketIndex);
        buckets.set(bucketIndex, newEntry);
        size++;

        // Redimensiona a tabela se o fator de carga for atingido
        if ((double) size / capacity >= loadFactor) {
            resize();
        }
    }

    // Retorna o valor associado à chave especificada
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        EntryMap<K, V> entry = buckets.get(bucketIndex);
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
    return null;
    }
    

    // Remove a entrada correspondente à chave especificada da tabela hash
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        EntryMap<K, V> entry = buckets.get(bucketIndex);
        EntryMap<K, V> prevEntry = null;
        
        // Busca a entrada correspondente à chave e guarda a entrada anterior
        while (entry != null) {
            if (entry.key.equals(key)) {
                break;
            }
            prevEntry = entry;
            entry = entry.next;
        }
    
        // Remove a entrada da lista encadeada e diminui o tamanho
        if (entry != null) {
            V value = entry.value;
            if (prevEntry == null) {
                buckets.set(bucketIndex, entry.next);
            } else {
                prevEntry.next = entry.next;
            }
            size--;
            return value;
        }
    
        return null;
    }
}
