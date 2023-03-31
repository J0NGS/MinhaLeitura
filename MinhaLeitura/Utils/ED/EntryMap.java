package Utils.ED;

import java.io.Serializable;

/*Classe para representar o elemento de entrada da hashtable */

public class EntryMap<K, V> implements Serializable {
    K key;                      // chave do elemento
    V value;                    // valor correspondente ao elemento

    public EntryMap(K key, V value){
        this.key = key;
        this.value = value;
    }

    public EntryMap() {
    }


    public K getKey() {
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}
