package Tests;

import java.time.LocalDate;
import java.time.LocalDateTime;

import SRC.Model.DAO.UserBookDAO;
import SRC.Model.DAO.Exceptions.ReadException;
import SRC.Model.VO.Book;
import SRC.Model.VO.User;
import SRC.Model.VO.UserBook;
import Utils.ED.LinkedListDouble;

public class TestUserBookDAO {
    public static void main(String[] args) {
        
        // Criando um UserBook
        UserBook userBook = new UserBook(2L, 2L, LocalDateTime.now(), null, 10, 3, "Comunismo", true);
        UserBook userBook2 = new UserBook(1L, 2L, LocalDateTime.now(), null, 15, 5, "Capitalismo", true);
        
        // Criando o DAO
        UserBookDAO userBookDAO = new UserBookDAO();
        
        // Testando o método create
        System.out.println("Teste do método create:");
        System.out.println(userBookDAO.create(userBook)); // Deve retornar true
        System.out.println(userBookDAO.create(userBook2)); // Deve retornar true
        
        // Testando o método read
        System.out.println("Teste do método read:");
        System.out.println(userBookDAO.readBook(1L)); // Deve imprimir as informações do UserBook
        System.out.println(userBookDAO.readBook(2L)); // Deve imprimir as informações do UserBook
        
        // Testando o método update
        System.out.println("Teste do método update:");
        userBook.setRating(4);
        System.out.println(userBookDAO.update(1L,  userBook)); // Deve retornar true
        System.out.println(userBookDAO.readBook(1L).getBook()); // Deve imprimir as informações atualizadas do UserBook
        System.out.println(userBookDAO.readBook(2L).getBook()); // Deve imprimir as informações atualizadas do UserBook
        //Testando método listBy
        LinkedListDouble<UserBook> result = userBookDAO.listByBook(1L);
        for(int i = result.getSize(); i >= 1; result.removeFirst()){
            System.out.println(result.peekFirst().getComment());
            i--;
        }
        
        // Testando o método delete
        System.out.println("Teste do método delete:");
        System.out.println(userBookDAO.delete(1L)); // Deve retornar true
        UserBook bookRead = userBookDAO.readBook(1L);
        try {
            System.out.println(bookRead.getComment()); // Deve lançar uma exceção ReadException
        } catch (ReadException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
