package Tests;

import java.time.LocalDate;

import SRC.Model.DAO.BookDAO;
import SRC.Model.VO.Book;
import Utils.ED.LinkedListDouble;

public class TestBookDAO {
    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();

        // Criação de livros
        Book book1 = new Book("Livro 1", "Autor 1", "Editora 1", LocalDate.now(), "Categoria 1");
        Book book2 = new Book("Livro 2", "Autor 2", "Editora 2", LocalDate.now(), "Categoria 2");
        Book book3 = new Book("Livro 10", "Autor 1", "Editora 1", LocalDate.now(), "Categoria 1");


        // Teste de criação
        System.out.println("Teste de criação:");
        System.out.println("Livro 1 criado com sucesso? " + bookDAO.create(book1));
        System.out.println("Livro 2 criado com sucesso? " + bookDAO.create(book2));

        // Teste de leitura
        System.out.println("\nTeste de leitura:");
        System.out.println(bookDAO.readBook(book1.getId()).getTitle());
        System.out.println(bookDAO.readBook(book2.getId()).getTitle());

        // Teste de atualização
        book1.setCategory("Nova categoria");
        System.out.println("\nTeste de atualização:");
        System.out.println("Livro 1 atualizado com sucesso? " + bookDAO.update(book1.getId(), book1));
        System.out.println(bookDAO.readBook(book1.getId()).getTitle());

        // Teste de busca pelo nome
        book1.setCategory("Busca por nome");
        System.out.println("\nBucando string 'Livro':");
        System.out.println("Resultado:");
        for(LinkedListDouble<Book> booksRead = bookDAO.listByName("Livro"); booksRead.peekFirst() != null;){
            System.out.println(booksRead.peekFirst().getTitle());
            booksRead.removeFirst();
        }

        // Teste de remoção
        System.out.println("\nTeste de remoção:");
        System.out.println("Livro 2 removido com sucesso? " + bookDAO.delete(book2.getId()));
    }

}
