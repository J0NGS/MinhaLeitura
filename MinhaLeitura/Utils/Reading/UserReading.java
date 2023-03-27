package Utils.Reading;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import SRC.Model.User;
import Utils.ED.LinkedListDouble;

public class UserReading {
    InputStream fileIn;
    public LinkedListDouble<User> reading(String arquivo) {
        LinkedListDouble<User> user = null;
        try {
            fileIn = new FileInputStream(arquivo);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            user = new LinkedListDouble<>();
            while(in.available() > 0){
               User aux = (User) in.readObject();
               user.addLast(aux);
            }
            in.close();
        }catch(IOException | ClassNotFoundException i){
        }
        return user;
    }

    public void close() throws IOException {
        fileIn.close();
    }
}
