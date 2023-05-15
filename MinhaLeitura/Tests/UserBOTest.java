package Tests;

import java.time.LocalDate;

import SRC.Model.BO.UserBO;
import SRC.Model.DAO.UserBookDAO;
import SRC.Model.DAO.UserDAO;
import SRC.Model.VO.Book;
import SRC.Model.VO.User;
import Utils.ED.LinkedListDouble;

public class UserBOTest {
    public static void main(String[] args) {
        UserBO userBO = new UserBO();
        
        //Criando usuários
        userBO.createUser("user1", "123456", "user1@gmail.com", "User One");
        userBO.createUser("user2", "abcdef", "user2@gmail.com", "User Two");
        userBO.createUser("user3", "654321", "user3@gmail.com", "User Three");

        //Testando busca por ID
        User user1 = userBO.searchById(0L);
        User user2 = userBO.searchById(1L);
        User user3 = userBO.searchById(2L);

        System.out.println("Usuário 1 encontrado: " + user1.getName()+ user1.getPassword()+ user1.getUsername());
        System.out.println("Usuário 2 encontrado: " + user2.getName());
        System.out.println("Usuário 3 encontrado: " + user3.getName());

        //Testando autenticação
        boolean auth1 = userBO.Authenticate("user1", "123456");
        boolean auth2 = userBO.Authenticate("user2", "abcdef");
        boolean auth3 = userBO.Authenticate("user3", "senha_errada");

        //Testando login
        User userLogin = userBO.login("user1", "123456");


        System.out.println("Autenticação usuário 1: " + auth1);
        System.out.println("Nome user1: " + userLogin.getName());
        System.out.println("Username user1: " + userLogin.getUsername());
        System.out.println("Password user1: " + userLogin.getPassword());
        System.out.println("Autenticação usuário 2: " + auth2);
        System.out.println("Autenticação usuário 3: " + auth3);

        //testando adicionar book na lista de livros do user

        Book book1 = new Book("1984", "George Orwell", "Companhia das Letras", LocalDate.of(1949, 6, 8), "Ficção Distópica");
        Book book2 = new Book("A Revolução dos Bichos", "George Orwell", "Companhia das Letras", LocalDate.of(1945, 8, 17), "Ficção");
        
        userBO.addBookList(0L, book1);
        userBO.addBookList(0L, book2);

        LinkedListDouble<Book> userBooks = userBO.listUserBook(0L);
        System.out.println(userBooks.peekFirst().getTitle());
        System.out.println(userBooks.peekFirst());
        userBooks.removeFirst();
        System.out.println(userBooks.peekFirst().getTitle());
        System.out.println(userBooks.peekFirst());
        
        //Testando adicionar um comentário
        UserBookDAO userBookDAO = new UserBookDAO();
        userBO.addComent(0L, 0L, "Viva o comunismo");
        System.out.println(userBookDAO.readBook(0L).getComment());

        userBO.addComent(0L, 0L, "Viva o liberalismo");
        System.out.println(userBookDAO.readBook(0L).getComment());

        //Testando adicionar uma avaliação
        userBO.addAvaliation(5, 0L, 0L);
        System.out.println(userBookDAO.readBook(0L).getRating());

        //Testando adicionar livro como "lendo"
        userBO.reading(0L, 0L);
        System.out.println(userBookDAO.readBook(0L).getReading());
        System.out.println(userBookDAO.readBook(0L).getStarDate());

        //Testando marcador de página
        userBO.bookmark(200, 0L, 0L);
        System.out.println(userBookDAO.readBook(0L).getPagesRead());
        
        //Testando adcionar livro como "concluido"
        userBO.read(0L,0L);
        System.out.println(userBookDAO.readBook(0L).getReading());
        System.out.println(userBookDAO.readBook(0L).getEndDate());

        //Testando lista de livros sendo lidos no momento
        userBO.reading(0L, 1L);
        userBooks = userBO.listUserBookRead(0L);
        for(int i = userBooks.getSize(); i > 0;){
            System.out.println(userBooks.peekFirst().getTitle());
            userBooks.removeFirst();
            i--;
        }

    }
}
