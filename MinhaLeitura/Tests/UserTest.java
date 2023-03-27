package Tests;

import SRC.Model.User;
import Utils.Reading.UserReading;
import Utils.Writer.UserWriter;

public class UserTest {
    public static void main(String[] args) {
        User freitinha = new User(1L, "fabricio", "dangelis", "DEbaixo do viaduto");
        
        String arquivo = "MinhaLeitura/Tests/Bin/user.bin";
        
        UserWriter writer = new UserWriter();
        writer.save(freitinha, arquivo);
        
        UserReading reading = new UserReading();
        User userRead = reading.reading(arquivo);
        System.out.println("Usuário lido do arquivo:");
        while(userRead != ){
        System.out.println("ID: " + userRead.getId());
        System.out.println("Username: " + userRead.getUsername());
        System.out.println("Password: " + userRead.getPassword());
        }
    }
}
