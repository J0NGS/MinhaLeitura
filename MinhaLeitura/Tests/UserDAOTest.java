package Tests;

import SRC.Model.DAO.UserDAO;
import SRC.Model.VO.User;

public class UserDAOTest {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        User user1 = new User("John", "12345","john@mail.com", "jhon textor");
        User user2 = new User("Mary","420", "mary@mail.com","Mary Joan");
        User user3 = new User("Bob","Belove" ,"bob@mail.com", "Bob Marley");

        // Testando o create
        boolean resultCreate1 = dao.create(user1);
        boolean resultCreate2 = dao.create(user2);
        boolean resultCreate3 = dao.create(user3);

        if (resultCreate1 && resultCreate2 && resultCreate3) {
            System.out.println("Usuários criados com sucesso.");
        } else {
            System.out.println("Houve um erro ao criar usuários.");
        }

        // Testando o read
        User userRead = dao.readUser(2L);

        if (userRead != null) {
            System.out.println("Usuário encontrado: " + userRead.getUsername());
        } else {
            System.out.println("Usuário não encontrado.");
        }

        // Testando o update
        System.out.println("Usuário antes do update " + user1.getUsername() );
        User userUpdate = new User("Jonathan", "1010","jonathan@mail.com", "João Nathan");
        boolean resultUpdate = dao.update(1L, userUpdate);
        User test = dao.readUser(1L);
        if (resultUpdate) {
            System.out.println("Usuário atualizado com sucesso. " + userUpdate.getUsername());
            System.out.println("Usuário atualizado com sucesso. " + test.getUsername());
        } else {
            System.out.println("Houve um erro ao atualizar o usuário.");
        }


        //Testando findByName
        String username = "Bob";
        userUpdate = dao.listByUsername(username);
        System.out.println("Usuário encontrado com sucesso. " + userUpdate.getName());

        //Testando findByName
        String email = "mary@mail.com";
        userUpdate = dao.listByEmail(email);
        System.out.println("Usuário encontrado com sucesso. " + userUpdate.getName());

        // Testando o delete
        boolean resultDelete = dao.delete(3L);

        if (resultDelete) {
            System.out.println("Usuário deletado com sucesso.");
        } else {
            System.out.println("Houve um erro ao deletar o usuário.");
        }
    }
}
