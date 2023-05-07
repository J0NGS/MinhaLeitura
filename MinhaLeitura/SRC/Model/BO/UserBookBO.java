package SRC.Model.BO;

import SRC.Model.BO.Exception.RegisterException;
import SRC.Model.DAO.UserBookDAO;
import SRC.Model.VO.UserBook;

import java.time.LocalDateTime;

public class UserBookBO {

    UserBookDAO dao = new UserBookDAO();

    public void createUserBook(Long book, Long userId, LocalDateTime startDate, LocalDateTime endDate, int pagesRead, int rating, String comment){
        try {

            //verificando conteudo dos paramentros
            if(book == null){
                throw new RegisterException("Id de livro inválido");
            }

            if(userId == null){
                throw new RegisterException("Id de usuário inválido");
            }

            if(startDate == null) {
                throw new RegisterException("Data de inicio inválida");
            }



            //instancia um novo livro e persiste
            UserBook userbook = new UserBook(book, userId, startDate, endDate, pagesRead, rating, comment, true);
            dao.create(userbook);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
