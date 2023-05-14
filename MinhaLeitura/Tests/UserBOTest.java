package Tests;

import SRC.Model.BO.UserBO;
import SRC.Model.DAO.UserDAO;
import SRC.Model.VO.User;

public class UserBOTest {
    public static void main(String[] args) {
        UserBO userBO = new UserBO();
        
        //Criando usuários
        userBO.createUser("user1", "123456", "user1@gmail.com", "User One");
        userBO.createUser("user2", "abcdef", "user2@gmail.com", "User Two");
        userBO.createUser("user3", "654321", "user3@gmail.com", "User Three");

        //Testando busca por ID
        User user1 = userBO.searchById(0L);
        User user2 = userBO.searchById(1L);
        User user3 = userBO.searchById(2L);

        System.out.println("Usuário 1 encontrado: " + user1.getName());
        System.out.println("Usuário 2 encontrado: " + user2.getName());
        System.out.println("Usuário 3 encontrado: " + user3.getName());

        //Testando autenticação
        boolean auth1 = userBO.Authenticate("user1", "123456");
        boolean auth2 = userBO.Authenticate("user2", "abcdef");
        boolean auth3 = userBO.Authenticate("user3", "senha_errada");

        //Testando login
        User userLogin = userBO.login("user1", "123456");


        System.out.println("Autenticação usuário 1: " + auth1);
        System.out.println("Nome user1: " + userLogin.getName());
        System.out.println("Username user1: " + userLogin.getUsername());
        System.out.println("Password user1: " + userLogin.getPassword());
        System.out.println("Autenticação usuário 2: " + auth2);
        System.out.println("Autenticação usuário 3: " + auth3);

        //testando book

    }
}
