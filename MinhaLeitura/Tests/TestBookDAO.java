package Tests;

import java.time.LocalDate;

import SRC.DAO.BookDAO;
import SRC.DAO.DAOInterface;
import SRC.Model.VO.Book;

public class TestBookDAO {
    public static void main(String[] args) {
        DAOInterface<Book> bookDAO = new BookDAO();

        // Criação de livros
        Book book1 = new Book(1L,"Livro 1", "Autor 1", "Editora 1", LocalDate.now(), "Categoria 1");
        Book book2 = new Book(2L,"Livro 2", "Autor 2", "Editora 2", LocalDate.now(), "Categoria 2");

        // Teste de criação
        System.out.println("Teste de criação:");
        System.out.println("Livro 1 criado com sucesso? " + bookDAO.create(book1));
        System.out.println("Livro 2 criado com sucesso? " + bookDAO.create(book2));

        // Teste de leitura
        System.out.println("\nTeste de leitura:");
        System.out.println(bookDAO.read(book1.getId()));
        System.out.println(bookDAO.read(book2.getId()));

        // Teste de atualização
        book1.setCategory("Nova categoria");
        System.out.println("\nTeste de atualização:");
        System.out.println("Livro 1 atualizado com sucesso? " + bookDAO.update(book1.getId(), book1));
        System.out.println(bookDAO.read(book1.getId()));

        // Teste de remoção
        System.out.println("\nTeste de remoção:");
        System.out.println("Livro 2 removido com sucesso? " + bookDAO.delete(book2.getId()));
    }

}
