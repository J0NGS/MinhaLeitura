package SRC.Model.BO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import SRC.Model.BO.Exception.InvalidArgumentException;
import SRC.Model.BO.Exception.NoFound;
import SRC.Model.BO.Exception.RegisterException;
import SRC.Model.DAO.BookDAO;
import SRC.Model.VO.Book;
import Utils.ED.LinkedList;
import Utils.ED.LinkedListDouble;

public class BookBO {

    BookDAO dao = new BookDAO();

    public void addBook(Book book){
        try {
            if(book.getTitle() == null || book.getTitle().isEmpty()){
                throw new RegisterException("Livro sem titúlo");
            }
            if(book.getCategory() == null || book.getCategory().isEmpty()){
                throw new RegisterException("Livro sem categoria");
            }
            if(book.getAuthor() == null || book.getAuthor().isEmpty()){
                throw new RegisterException("Livro sem autor/a");
            }
            if(book.getPublishe() == null || book.getPublishe().isEmpty()){
                throw new RegisterException("Livro sem editora");
            }
            if(book.getReleaseDate() == null || book.getReleaseDate().isAfter(LocalDate.now())){
                throw new RegisterException("Data de lançamento inválida");
            }    
        } catch (Exception e) {
            e.getMessage();
        }

        LinkedListDouble<Book> verifyBook = new LinkedListDouble<>();

        try {
            // Verificando se livro já existe no sistema
            verifyBook = dao.listByName(book.getTitle());
        }catch (Exception e) {
            e.getSuppressed();
            dao.create(book);
            verifyBook = dao.listByName(book.getTitle());
        }


        if(verifyBook.peekFirst() != null){
            for(;verifyBook.peekFirst() != null; verifyBook.removeFirst()){
                if(verifyBook.peekFirst().getTitle().equals(book.getTitle())
                && verifyBook.peekFirst().getAuthor().equals(book.getAuthor()) 
                && verifyBook.peekFirst().getReleaseDate().equals(book.getReleaseDate())
                && verifyBook.peekFirst().getPublishe().equals(book.getPublishe())){
                    book.setId(verifyBook.peekFirst().getId());
                    break;
                } else {
                    dao.create(book);
                }
            } 
        } else {
            dao.create(book);
        }
    }

    public Book findBookByName(String name){
        try {
            if(name == null || name.isEmpty()){
                throw new InvalidArgumentException("Nome para pesquisa inválido");
            }


            Book result = new Book();
            LinkedListDouble<Book> books = dao.listByName(name);
            if(books.peekFirst() == null){
                throw new NoFound("Nenhum livro encontrado");
            } 

            for(; books.peekFirst() != null; books.removeFirst()){
                if(books.peekFirst().getTitle().equals(name)){
                    result = books.peekFirst();
                }
            }
            
            if (result == null){
                throw new NoFound("Nenhum livro encontrado");
            }
            return result;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public LinkedListDouble<Book> findListBookByName(String name){
        try {
            if(name == null || name.isEmpty()){
                throw new InvalidArgumentException("Nome inválido");
            }
            return dao.listByName(name);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    } 
}
