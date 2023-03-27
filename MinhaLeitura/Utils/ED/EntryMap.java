package Utils.ED;

/*Classe para representar o elemento de entrada da hashtable */

public class EntryMap<K, V> {
    K key;                      // chave do elemento
    V value;                    // valor correspondente ao elemento
    EntryMap<K, V> next;        // ponteiro para proximo elemento da lista

    public EntryMap(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
