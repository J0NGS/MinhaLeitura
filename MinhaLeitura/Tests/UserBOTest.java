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
        User user1 = userBO.searchById(1L);
        User user2 = userBO.searchById(2L);
        User user3 = userBO.searchById(3L);

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

        //Testando criação de usuário inválido
        try {
            userBO.createUser(null, "123456", "user4@gmail.com", "User Four");
        } catch (Exception e) {
            e.getMessage();
        }

        try {
            userBO.createUser("user5", "", "user5@gmail.com", "User Five");
        } catch (Exception e) {
            e.getMessage();
        }

        try {
            userBO.createUser("user6", "abcdef", "user6.gmail.com", "User Six");
        } catch (Exception e) {
            e.getMessage();
        }

        try {
            userBO.createUser("user7", "123456", "", "User Seven");
        } catch (Exception e) {
            e.getMessage();
        }

        //Testando busca por ID inválido
        try {
            User user4 = userBO.searchById(4L);
            System.out.println("Usuário 4 encontrado: " + user4.getName());
        } catch (Exception e) {
            e.getMessage();
        }

        try {
            User user0 = userBO.searchById(0L);
            System.out.println("Usuário 0 encontrado: " + user0.getName());
        } catch (Exception e) {
            e.getMessage();
        }

        //Testando autenticação com dados inválidos
        try {
            boolean auth4 = userBO.Authenticate(null, "123456");
        } catch (Exception e) {
            e.getMessage();
        }

        try {
            boolean auth5 = userBO.Authenticate("user8", "");
        } catch (Exception e) {
            e.getMessage();
        }

    }
}
