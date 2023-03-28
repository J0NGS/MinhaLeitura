package Utils.Writer;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import Utils.ED.HashTable;

public class HashTableWriter <K,V>{
    
    public void save(HashTable<K, V> hashTable, String caminho) {
        try {
            FileOutputStream fileOut = new FileOutputStream(caminho);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(hashTable);
            objectOut.close();
            System.out.println("A HashTable foi salva no arquivo " + caminho);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
