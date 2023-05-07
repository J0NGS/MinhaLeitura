package SRC.Model.BO;

import SRC.Model.BO.Exception.RegisterException;
import SRC.Model.DAO.BookDAO;
import SRC.Model.VO.Book;
import Utils.ED.LinkedListDouble;

import java.time.LocalDate;

public class BookBO {
    BookDAO dao = new BookDAO();

    public void createBook(String title, String author, String puclishe, LocalDate releaseDate, String category){
        try {

            //verificando conteudo dos paramentros
            if(title == null || title.isEmpty()){
                throw new RegisterException("Titulo inválido");
            }

            if(author == null || author.isEmpty()){
                throw new RegisterException("Autor inválido");
            }

            if(puclishe == null || puclishe.isEmpty()){
                throw new RegisterException("Editora inválida");
            }

            if(category == null || category.isEmpty()){
                throw new RegisterException("Gênero inválido");
            }

            if(releaseDate == null){
                throw new RegisterException("Data de publicação inválido");
            }

            //instancia um novo livro e persiste
            Book book = new Book(title, author, puclishe, releaseDate, category);
            dao.create(book);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public LinkedListDouble<Book> searchByTitle(String title) {
        LinkedListDouble<Book> livros = new LinkedListDouble<>();
        try {
            livros = dao.listByName(title);
        } catch (Exception e) {
            throw new RuntimeException("Livro não encontrado");
        }

        return livros;
    }

    public LinkedListDouble<Book> searchByAuthor(String author) {
        LinkedListDouble<Book> livros = new LinkedListDouble<>();
        try {
            livros = dao.listByAuthor(author);
        } catch (Exception e) {
            throw new RuntimeException("Livro não encontrado");
        }

        return livros;
    }

    public LinkedListDouble<Book> searchByPublischer(String publisher) {
        LinkedListDouble<Book> livros = new LinkedListDouble<>();
        try {
            livros = dao.listByPublisher(publisher);
        } catch (Exception e) {
            throw new RuntimeException("Livro não encontrado");
        }

        return livros;
    }

    public LinkedListDouble<Book> searchByCategory(String category) {
        LinkedListDouble<Book> livros = new LinkedListDouble<>();
        try {
            livros = dao.listByCategory(category);
        } catch (Exception e) {
            throw new RuntimeException("Livro não encontrado");
        }

        return livros;
    }
}
