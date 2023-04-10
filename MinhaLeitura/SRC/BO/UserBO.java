package SRC.BO;

import SRC.DAO.UserDAO;
import SRC.DAO.Exceptions.CreateException;
import SRC.VO.User;

public class UserBO {
   UserDAO dao = new UserDAO();

   public void createUser(String username, String password){
    if(username == null || username.isEmpty()){
        throw new CreateException("Usuário inválido");
    }

    if(password == null || password.isEmpty()){
        throw new CreateException("Password inválido");
    }

    User user = new User(null, username, password);
    dao.create(user);
   }

}
