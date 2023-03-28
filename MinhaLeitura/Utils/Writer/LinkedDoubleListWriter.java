package Utils.Writer;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import Utils.ED.LinkedListDouble;

public class LinkedDoubleListWriter <T>{
    public void save(LinkedListDouble<T> list, String path){
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(list);
            objectOut.close();
            System.out.println("A lista Duplamente encadeada foi salva no arquivo " + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
