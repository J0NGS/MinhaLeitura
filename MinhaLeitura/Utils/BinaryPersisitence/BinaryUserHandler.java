package Utils.BinaryPersisitence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import SRC.VO.User;
import Utils.ED.HashTable;

public class BinaryUserHandler {
    private String fileName;

    public BinaryUserHandler(String fileName) {
        this.fileName = fileName;
        File file = new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.fileName));
                out.writeObject(new HashTable<Long, User>());
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void save(HashTable<Long, User> users){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.fileName));
            out.writeObject(users);
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public HashTable<Long, User> read() {
        HashTable<Long, User> users = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.fileName));
            users = (HashTable<Long, User>) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void delete() {
        File file = new File(this.fileName);
        file.delete();
    }
}