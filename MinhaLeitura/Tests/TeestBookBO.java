package Tests;

import java.time.LocalDate;

import SRC.Model.BO.BookBO;
import SRC.Model.DAO.BookDAO;
import SRC.Model.VO.Book;

public class TeestBookBO {
    public static void main(String[] args) {
    // Criação de livros
    Book book1 = new Book("1984", "George Orwell", "Companhia das Letras", LocalDate.of(1949, 6, 8), "Ficção Distópica");
    Book book2 = new Book("A Revolução dos Bichos", "George Orwell", "Companhia das Letras", LocalDate.of(1945, 8, 17), "Ficção");

    BookBO test = new BookBO();

    test.addBook(book1);
    test.addBook(book2);

    BookDAO dao = new BookDAO();
    book2 = test.findBookByName("1984");
    
    System.out.println(book2.getTitle());

    //test.

    }
}
