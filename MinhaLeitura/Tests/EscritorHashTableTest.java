package Tests;

import Utils.ED.HashTable;
import Utils.Writer.HashTableWriter;

public class EscritorHashTableTest {
public static void main(String[] args) {
    HashTable<String, Integer> hashTable = new HashTable<>();
    hashTable.put("chave1", 10);
    hashTable.put("chave2", 20);

    HashTableWriter<String, Integer> escritor = new HashTableWriter<>();
    escritor.save(hashTable, "E://Documentos/UFERSA/Disciplinas/ED1/MinhaLeitura/MinhaLeitura/Tests/Bin/hashTable.bin");
}
}
