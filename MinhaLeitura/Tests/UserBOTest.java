package Tests;

import SRC.Model.BO.UserBO;
import SRC.Model.DAO.UserDAO;
import SRC.Model.VO.User;

public class UserBOTest {
    public static void main(String[] args) {
        UserBO bo = new UserBO();
        bo.createUser("jnetogoncalo", "123456");
        UserDAO dao = new UserDAO();
        User userRead = dao.readUser(1L);
        System.out.println(userRead.getUsername());
        System.out.println(userRead.getId());
    }
}
