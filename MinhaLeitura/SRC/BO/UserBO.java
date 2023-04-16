package SRC.BO;

import SRC.DAO.UserDAO;
import SRC.DAO.Exceptions.CreateException;
import SRC.DAO.Exceptions.ReadException;
import SRC.Model.VO.User;
import Utils.ED.LinkedListDouble;

public class UserBO {
   UserDAO dao = new UserDAO();

   public void createUser(String username, String password){
    try {
        if(username == null || username.isEmpty()){
            throw new CreateException("Usuário inválido");
        }
    
        if(password == null || password.isEmpty()){
            throw new CreateException("Password inválido");
        }
    
        User user = new User(null, username, password);
        dao.create(user);
    } catch (Exception e) {
        e.printStackTrace();
    }
   }

   public User searchById(Long id){
    try {
        if(id == null || id < 1){
            throw new ReadException("Id Inválido");
        }
        
        User user = dao.readUser(id);
        return user;

    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
  }

  public boolean Authenticate(String username, String password){
    boolean authenticate = false;
    try {
        if(username == null || username.isEmpty()){
            throw new CreateException("Usuário inválido");
        }
    
        if(password == null || password.isEmpty()){
            throw new CreateException("Password inválido");
        }
        
        LinkedListDouble<User> users = new LinkedListDouble<>();
        users = dao.read();
        User user = new User(username, password);
        User userRead = users.search(user);
        

    } catch (Exception e) {
        e.printStackTrace();
        return authenticate;
    }
  }
}