package Tests;

import SRC.BO.UserBO;
import SRC.DAO.UserDAO;
import SRC.VO.User;

public class BookBOTest {
    public static void main(String[] args) {
        UserBO bo = new UserBO();
        bo.createUser("jnetogoncalo", "123456");
        UserDAO dao = new UserDAO();
        User userRead = dao.read(1L);
        System.out.println(userRead.getUsername());
    }
}
