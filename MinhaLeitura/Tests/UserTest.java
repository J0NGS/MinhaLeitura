package Tests;

import java.io.IOException;
import java.util.Hashtable;

import SRC.Model.User;
import Utils.ED.HashTable;
import Utils.Reading.ReadingHashTable;
import Utils.Writer.HashTableWriter;

public class UserTest {
    public static void main(String[] args) {
        HashTable<Long, User> users = new HashTable<>();
        HashTable<Long, User> hashReturn = new HashTable<>();
        User userReturn = null;
        User userTest = new User(1L, "jotaNeto", "123456");
        HashTableWriter<Long, User> writer = new HashTableWriter<>();
        ReadingHashTable<Long, User> reading = new ReadingHashTable<>("E://Documentos/UFERSA/Disciplinas/ED1/MinhaLeitura/MinhaLeitura/Tests/Bin/UserTest.bin");
        users.put(userTest.getId(), userTest);
        writer.save(users, "E://Documentos/UFERSA/Disciplinas/ED1/MinhaLeitura/MinhaLeitura/Tests/Bin/UserTest.bin");
        try {
            hashReturn = reading.read();
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        userReturn = hashReturn.get(userTest.getId());
        System.out.println(userReturn.getUsername());

    }    
}
