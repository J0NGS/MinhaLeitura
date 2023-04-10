package Utils.BinaryPersisitence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import SRC.Model.VO.UserBook;
import Utils.ED.HashTable;

public class BinaryUserBookHandler {
    private String fileName;

    public BinaryUserBookHandler(String fileName) {
        this.fileName = fileName;
    }

    public void save(HashTable<Long, UserBook> books) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.fileName));
            out.writeObject(books);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashTable<Long, UserBook> read() {
        HashTable<Long, UserBook> books = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.fileName));
            books = (HashTable<Long, UserBook>) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void delete() {
        File file = new File(this.fileName);
        file.delete();
    }
}

