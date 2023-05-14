package SRC.Model.BO;

import java.io.EOFException;

import SRC.Model.BO.Exception.AddBookException;
import SRC.Model.BO.Exception.LoginException;
import SRC.Model.BO.Exception.RegisterException;
import SRC.Model.DAO.BookDAO;
import SRC.Model.DAO.UserBookDAO;
import SRC.Model.DAO.UserDAO;
import SRC.Model.DAO.Exceptions.CreateException;
import SRC.Model.DAO.Exceptions.ReadException;
import SRC.Model.VO.Book;
import SRC.Model.VO.User;
import SRC.Model.VO.UserBook;
import Utils.ED.LinkedList;
import Utils.ED.LinkedListDouble;

public class UserBO {
   private UserDAO dao = new UserDAO();
   private UserBookDAO userBookDao = new UserBookDAO();
   private BookDAO bookDao = new BookDAO();
   private BookBO bookBo;

/**
 * Função para cadastrar o usuário
 * @param username username do user
 * @param password senha do user
 * @param email email do user
 * @param name nome do user
 */
   public void createUser(String username, String password, String email, String name){
    try {

        //verificando conteudo dos paramentros
        if(username == null || username.isEmpty()){
            throw new RegisterException("Usuário inválido");
        }
    
        if(password == null || password.isEmpty()){
            throw new RegisterException("Password inválido");
        }

        if(email == null || email.isEmpty() || !email.contains("@")){
            throw new RegisterException("Email inválido");
        }

        if(name == null || name.isEmpty()){
            throw new RegisterException("Nome inválido");
        }
        //instancia um novo usuário e persiste
        User user = new User(username, password, email, name);
        dao.create(user);
    } catch (Exception e) {
        e.getMessage();
    }
   }

   /**
    * Metodo para buscar user pelo id
    * @param id do user
    * @return entidade user
    */

   public User searchById(Long id){
    try {
        if(id == null || id < 0){
            throw new ReadException("Id Inválido");
        }
        
        User user = dao.readUser(id);
        return user;

    } catch (Exception e) {
        e.getMessage();
        return null;
    }
  }

  /**
   * Metódo para fazer login e autenticar user
   * @param username do user
   * @param password para ser validade
   * @return user entidade user
   */
  public User login(String username, String password){
    try{
        if(Authenticate(username, password)){
        User user = dao.listByUsername(username);
        return user;
    }else{
        throw new LoginException("Dados de login incorretos");
    }
    }catch(Exception e){
        e.getMessage();
        return null;
    }
  }
 
  public Boolean addBookList(Long userId,Book book){
    try {
        bookBo.addBook(book);
        LinkedListDouble<Book>userBooks = listUserBook(userId);
        for(;userBooks.peekFirst() != null; userBooks.removeFirst()){
            if(userBooks.peekFirst().equals(book)){
                throw new AddBookException("Livro já está na lista do user");
            }
        }
        
        Book bookUser = bookBo.findBookByName(book.getTitle());
    
        UserBook userBook = new UserBook(bookUser.getId(),userId , null, null, 0, 0, null, false);
        return userBookDao.create(userBook);    
    } catch (Exception e) {
        e.getMessage();
        return false;
    }
  }

  /**
   * Método que retorna os livros que o usuário já possui
   * @param userId id do usuário propriétario dos livros
   * @return lista duplamente encadeada com livros retornados
   */
  public LinkedListDouble<Book> listUserBook(Long userId){
    try {
        if(userId == null || userId == 0L){
            throw new AddBookException("Id de user inválido");
        }

        LinkedListDouble<Book> books = new LinkedListDouble<>();
        for(LinkedList<Long> listBooks = userBookDao.listUserBooks(userId); listBooks.peekFirst()!= null; listBooks.removeFirst()){
            books.addFirst(bookDao.readBook(listBooks.peekFirst()));
        }
        return books;
    } catch (Exception e) {
        e.getMessage();
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
        
        User users = dao.listByUsername(username);
        if(users.getPassword().equals(password)){
            authenticate = true;}
        else{
            throw new ReadException("password incorreto");
        }
        return authenticate;
    } catch (Exception e) {
        e.getMessage();
        return authenticate;
    }
  }
}