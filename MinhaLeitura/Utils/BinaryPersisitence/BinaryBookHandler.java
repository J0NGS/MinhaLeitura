package Utils.BinaryPersisitence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import SRC.VO.Book;
import Utils.ED.HashTable;

public class BinaryBookHandler {
    private String fileName;

    public BinaryBookHandler(String fileName) {
        this.fileName = fileName;
    }

    public void save(HashTable<Long, Book> books) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.fileName));
            out.writeObject(books);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashTable<Long, Book> read() {
        HashTable<Long, Book> books = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.fileName));
            books = (HashTable<Long, Book>) in.readObject();
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
