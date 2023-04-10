package Utils.BinaryPersisitence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import SRC.Model.VO.UserReading;

public class BinaryUserReadingHandler {
    private String fileName;

    public BinaryUserReadingHandler(String fileName) {
        this.fileName = fileName;
    }

    public void save(UserReading books) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.fileName));
            out.writeObject(books);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserReading read() {
        UserReading Readings = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.fileName));
            Readings = (UserReading) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Readings;
    }

    public void delete() {
        File file = new File(this.fileName);
        file.delete();
    }
}

