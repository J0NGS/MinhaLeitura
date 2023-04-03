package Tests;

import java.time.LocalDate;

import SRC.Model.VO.Book;
import SRC.Model.VO.UserBook;
import SRC.Model.VO.UserReading;
import Utils.BinaryPersisitence.BinaryUserReadingHandler;
import Utils.ED.HashTable;

public class TestUserReadingHandler {
    public static void main(String[] args) {
        
        // Criando alguns livros
        Book book1 = new Book(1L, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Bloomsbury Publishing", LocalDate.of(1997, 6, 26), "Fantasy");
        Book book2 = new Book(2L, "The Hobbit", "J.R.R. Tolkien", "Allen & Unwin", LocalDate.of(1937, 9, 21), "Fantasy");
        Book book3 = new Book(3L, "1984", "George Orwell", "Secker & Warburg", LocalDate.of(1949, 6, 8), "Dystopian Fiction");
        
        // Criando alguns UserBook
        UserBook userBook1 = new UserBook(1L, LocalDate.now(), LocalDate.now().plusDays(7), 100, 5, "Excelente livro!", true);
        UserBook userBook2 = new UserBook(2L, LocalDate.now(), LocalDate.now().plusDays(14), 200, 4, "Muito bom", true);
        UserBook userBook3 = new UserBook(3L, LocalDate.now(), LocalDate.now().plusDays(30), 50, 3, "Não gostei tanto assim", false);

        // Criando uma HashTable para armazenar os UserBook
        HashTable<Long, UserBook> userBookTable = new HashTable<>();
        userBookTable.put(userBook1.getBook(), userBook1);
        userBookTable.put(userBook2.getBook(), userBook2);
        userBookTable.put(userBook3.getBook(), userBook3);

        // Criando um objeto UserReading que contém a HashTable com os UserBook
        UserReading userReading = new UserReading(1L, userBookTable);
        
        // Salvando o objeto UserReading em um arquivo binário
        BinaryUserReadingHandler binaryHandler = new BinaryUserReadingHandler("E://Documentos/UFERSA/Disciplinas/ED1/MinhaLeitura/MinhaLeitura/Tests/Bin/UserReadingTest.bin");
        binaryHandler.save(userReading);
        
        // Carregando o objeto UserReading do arquivo binário
        UserReading loadedUserReading = binaryHandler.read();
        HashTable<Long, UserBook> userBookLoad = new HashTable<>();
        userBookLoad = loadedUserReading.getUserBooks();
        UserBook aux = new UserBook();
        
        // Imprimindo os livros do usuário
        for (Long i = 1L; i <= userBookLoad.size(); i++) {
            aux = userBookLoad.get(i);
            System.out.println("Book ID: " + aux.getBook());
            System.out.println("User ID: " + loadedUserReading.getUserId());
            System.out.println("Start date: " + aux.getStarDate());
            System.out.println("End date: " + aux.getEndDate());
            System.out.println("Pages read: " + aux.getPagesRead());
            System.out.println("Rating: " + aux.getRating());
            System.out.println("Comment: " + aux.getComment());
            System.out.println("Reading: " + aux.isReading());
            System.out.println("---------------------");
        }
        
        // Deletando o arquivo binário
        binaryHandler.delete();
    }

}
