package Tests;

import SRC.Model.VO.User;
import Utils.BinaryPersisitence.BinaryUserHandler;
import Utils.ED.HashTable;

public class TestUserBinary {
    public static void main(String[] args) {

        // Criando alguns objetos de usuário
        User user1 = new User(0L, "joao@example.com", "123456");
        User user2 = new User(1L, "maria@example.com", "654321");
        User user3 = new User(2L, "pedro@example.com", "987654");

        // Criando uma HashTable de usuários
        HashTable<Long, User> users = new HashTable<>();
        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
        users.put(user3.getId(), user3);

        // Salvando a HashTable em um arquivo binário
        BinaryUserHandler userHandler = new BinaryUserHandler("E://Documentos/UFERSA/Disciplinas/ED1/MinhaLeitura/MinhaLeitura/Tests/Bin/UserTest.bin");
        userHandler.save(users);

        // Lendo a HashTable do arquivo binário
        HashTable<Long, User> usersFromFile = (HashTable<Long, User>) userHandler.read();

        // Imprimindo os usuários lidos do arquivo
        for (Long i = 0L; i < usersFromFile.size(); i++) {
            User user = usersFromFile.get(i);
            System.out.println("ID->" + user.getId());
            System.out.println("username->" + user.getUsername());
            System.out.println("password->" + user.getPassword());
        }
    }
}
