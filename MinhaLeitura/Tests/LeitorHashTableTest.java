package Tests;

import java.io.IOException;

import Utils.ED.EntryMap;
import Utils.ED.HashTable;
import Utils.Reading.ReadingHashTable;

public class LeitorHashTableTest {
    public static void main(String[] args) {
        // criar o leitor e ler a hashtable do arquivo
        String filePath = "E://Documentos/UFERSA/Disciplinas/ED1/MinhaLeitura/MinhaLeitura/Tests/Bin/hashTable.bin";
        ReadingHashTable<String, Integer> reader = new ReadingHashTable<>(filePath);
        HashTable<String, Integer> table = null;
        try {
            table = reader.read();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // percorrer a lista de entradas e imprimir chave e valor de cada entrada
        int i = table.get("chave1");
        System.out.println(i); // 10
    }
}
