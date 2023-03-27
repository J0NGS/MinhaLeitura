package Utils.Writer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import SRC.Model.User;

public class UserWriter {

    public void save(User user, String path){
        OutputStream fileOut;
        try {
            fileOut = new FileOutputStream(path, true);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(user.getId());
            out.writeObject(user.getUsername());
            out.writeObject(user.getPassword());
            out.writeObject(user.getEndereco());
            out.close();
            fileOut.close();
            System.out.println("O usuário foi salvo em " + path);
        } catch(IOException i) {
            i.printStackTrace();
        }
    }

}