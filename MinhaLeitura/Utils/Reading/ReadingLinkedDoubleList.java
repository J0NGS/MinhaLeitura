package Utils.Reading;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Utils.ED.LinkedListDouble;

public class ReadingLinkedDoubleList <T>{
    private String path;
    
    public ReadingLinkedDoubleList(String path){
        this.path = path;
    }

    public LinkedListDouble<T> read()throws IOException, ClassCastException{
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        LinkedListDouble<T> list = (LinkedListDouble<T>)ois.readObject();
        ois.close();
        return list;
    }
}
