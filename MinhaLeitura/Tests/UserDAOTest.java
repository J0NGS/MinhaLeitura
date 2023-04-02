package Tests;

import SRC.DAO.UserDAO;
import SRC.VO.User;

public class UserDAOTest {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        User user1 = new User(1L, "John", "john@mail.com");
        User user2 = new User(2L, "Mary", "mary@mail.com");
        User user3 = new User(3L, "Bob", "bob@mail.com");

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
        User userRead = dao.read(2L);

        if (userRead != null) {
            System.out.println("Usuário encontrado: " + userRead.getUsername());
        } else {
            System.out.println("Usuário não encontrado.");
        }

        // Testando o update
        User userUpdate = new User(1L, "Jonathan", "jonathan@mail.com");
        boolean resultUpdate = dao.update(1L, userUpdate);

        if (resultUpdate) {
            System.out.println("Usuário atualizado com sucesso.");
        } else {
            System.out.println("Houve um erro ao atualizar o usuário.");
        }

        // Testando o delete
        boolean resultDelete = dao.delete(3L);

        if (resultDelete) {
            System.out.println("Usuário deletado com sucesso.");
        } else {
            System.out.println("Houve um erro ao deletar o usuário.");
        }
    }
}
