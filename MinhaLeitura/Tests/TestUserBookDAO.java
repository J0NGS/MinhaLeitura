package Tests;

import java.time.LocalDate;
import java.time.LocalDateTime;

import SRC.Model.DAO.UserBookDAO;
import SRC.Model.DAO.Exceptions.ReadException;
import SRC.Model.VO.Book;
import SRC.Model.VO.User;
import SRC.Model.VO.UserBook;

public class TestUserBookDAO {
    public static void main(String[] args) {
        
        // Criando um usuário
        User user = new User("teste","teste","fulano@teste.com", "senha123");
        
        // Criando um livro
        Book book = new Book("A Revolução dos Bichos", "George Orwell", "Companhia das Letras", LocalDate.of(1945, 8, 17), "Ficção");
        
        // Criando um UserBook
        UserBook userBook = new UserBook(null, book.getId(), null, null, 0, 0, "Comunismo", true);
        
        // Criando o DAO
        UserBookDAO userBookDAO = new UserBookDAO();
        
        // Testando o método create
        System.out.println("Teste do método create:");
        System.out.println(userBookDAO.create(userBook)); // Deve retornar true
        
        // Testando o método read
        System.out.println("Teste do método read:");
        //System.out.println(userBookDAO.read(book.getId())); // Deve imprimir as informações do UserBook
        
        // Testando o método update
        System.out.println("Teste do método update:");
        userBook.setRating(4);
        System.out.println(userBookDAO.update(book.getId(),  userBook)); // Deve retornar true
        //System.out.println(userBookDAO.read(book.getId())); // Deve imprimir as informações atualizadas do UserBook
        
        // Testando o método delete
        /*
        System.out.println("Teste do método delete:");
        System.out.println(userBookDAO.delete(book.getId())); // Deve retornar true
        UserBook bookRead = userBookDAO.read(book.getId());
        try {
            System.out.println(bookRead.getComment()); // Deve lançar uma exceção ReadException
        } catch (ReadException e) {
            System.out.println(e.getMessage());
        }*/
        
    }
}
