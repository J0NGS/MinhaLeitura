package Tests;

import java.time.LocalDate;

import SRC.Model.VO.Book;
import Utils.BinaryPersisitence.BinaryBookHandler;
import Utils.ED.HashTable;

public class TestBookBinary {
    public static void main(String[] args) {
        // Criação de alguns livros
        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Bloomsbury Publishing", LocalDate.of(1997, 6, 26), "Fantasy");
        Book book2 = new Book("The Hobbit", "J.R.R. Tolkien", "Allen & Unwin", LocalDate.of(1937, 9, 21), "Fantasy");
        Book book3 = new Book("1984", "George Orwell", "Secker & Warburg", LocalDate.of(1949, 6, 8), "Dystopian Fiction");

        // Criação de uma hash table e adição dos livros
        HashTable<Long, Book> books = new HashTable<>(10);
        books.put(book1.getId(), book1);
        books.put(book2.getId(), book2);
        books.put(book3.getId(), book3);

        // Criação de um handler para livros
        BinaryBookHandler bookHandler = new BinaryBookHandler("E://Documentos/UFERSA/Disciplinas/ED1/MinhaLeitura/MinhaLeitura/Tests/Bin/BookTest.bin");

        // Salvando a hash table em um arquivo binário
        bookHandler.save(books);

        // Lendo a hash table a partir do arquivo binário
        HashTable<Long, Book> readBooks = bookHandler.read();

        // Imprimindo os livros lidos
        for (Long i = 1L; i <= readBooks.size(); i++) {
            Book book = readBooks.get(i);
            System.out.println("ID-> " + book.getId());
            System.out.println("Name-> " + book.getTitle());
            System.out.println("Author-> " + book.getAuthor());
            System.out.println("Publisher-> " + book.getPublishe());
            System.out.println("Release Date -> " + book.getReleaseDate());
            System.out.println("Category -> " + book.getCategory());
            System.out.println();
        }

    }
}
