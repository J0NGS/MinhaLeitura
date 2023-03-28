package Utils.Reading;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Utils.ED.HashTable;

public class ReadingHashTable <K,V>{
    private String filePath;

    public ReadingHashTable(String filePath) {
        this.filePath = filePath;
    }

    public HashTable<K, V> read () throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        HashTable<K, V> hashTable = (HashTable<K, V>) ois.readObject();
        ois.close();
        return hashTable;
    }
}
