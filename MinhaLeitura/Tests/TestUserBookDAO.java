package Tests;

import java.time.LocalDate;

import SRC.DAO.BookDAO;
import SRC.DAO.UserBookDAO;
import SRC.DAO.Exceptions.ReadException;
import SRC.VO.Book;
import SRC.VO.User;
import SRC.VO.UserBook;

public class TestUserBookDAO {
    public static void main(String[] args) {
        
        // Criando um usuário
        User user = new User(1L, "fulano@teste.com", "senha123");
        
        // Criando um livro
        Book book = new Book(1L,"A Revolução dos Bichos", "George Orwell", "Companhia das Letras", LocalDate.of(1945, 8, 17), "Ficção");
        
        // Criando um UserBook
        UserBook userBook = new UserBook(book.getId(), LocalDate.of(2022, 3, 30), null, 0, 0, "Comunismo", true);
        
        // Criando o DAO
        UserBookDAO userBookDAO = new UserBookDAO();
        
        // Testando o método create
        System.out.println("Teste do método create:");
        System.out.println(userBookDAO.create(userBook)); // Deve retornar true
        
        // Testando o método read
        System.out.println("Teste do método read:");
        System.out.println(userBookDAO.read(book.getId())); // Deve imprimir as informações do UserBook
        
        // Testando o método update
        System.out.println("Teste do método update:");
        userBook.setRating(4);
        System.out.println(userBookDAO.update(book.getId(),  userBook)); // Deve retornar true
        System.out.println(userBookDAO.read(book.getId())); // Deve imprimir as informações atualizadas do UserBook
        
        // Testando o método delete
        System.out.println("Teste do método delete:");
        System.out.println(userBookDAO.delete(book.getId())); // Deve retornar true
        UserBook bookRead = userBookDAO.read(book.getId());
        try {
            System.out.println(bookRead.getComment()); // Deve lançar uma exceção ReadException
        } catch (ReadException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
