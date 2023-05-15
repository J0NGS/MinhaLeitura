import java.time.LocalDate;
import java.util.Scanner;

import SRC.Model.BO.BookBO;
import SRC.Model.BO.UserBO;
import SRC.Model.DAO.UserBookDAO;
import SRC.Model.VO.Book;
import SRC.Model.VO.User;
import Utils.ED.LinkedListDouble;

public class MinhaLeitura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        UserBO userBo = new UserBO();
        BookBO bookBo =  new BookBO();
        UserBookDAO userBookDAO = new UserBookDAO();

        while (!sair) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    User user = new User();
                    limparTela();
                    System.out.println("Opção escolhida: Cadastrar");
                    
                    System.out.println("Digite o username escolhido");
                    user.setUsername(scanner.nextLine());
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.println("Digite a senha escolhida");
                    user.setPassword(scanner.nextLine());
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.println("Digite o seu email");
                    user.setEmail(scanner.nextLine());
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.println("Digite o seu nome");
                    user.setName(scanner.nextLine());
                    
                    userBo.createUser(user.getUsername(),user.getPassword(),user.getEmail(),user.getName());
                    scanner.nextLine(); // Limpar o buffer do scanner
                    break;
                case 2:
                    User aux = new User();
                    limparTela();
                    System.out.println("Opção escolhida: Entrar");
                    
                    System.out.println("Digite seu username");
                    aux.setUsername(scanner.nextLine());
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.println("Digite sua senha");
                    aux.setPassword(scanner.nextLine());
                    scanner.nextLine(); // Limpar o buffer do scanner

                    User userCache = userBo.login(aux.getUsername(),aux.getPassword());                    
                    scanner.nextLine(); // Limpar o buffer do scanner

                    if (userCache != null) {
                        boolean logado = true;
                
                        while (logado) {
                            exibirMenuLogado();
                            int opcaoLogado = scanner.nextInt();
                            scanner.nextLine(); // Limpar o buffer do scanner
                
                            switch (opcaoLogado) {
                                case 1:
                                    limparTela();
                                    System.out.println("Opção escolhida: Cadastrar livro");
                                    Book book = new Book();   
                                    System.out.println("Nome do livro");
                                    book.setTitle(scanner.nextLine());
                                    scanner.nextLine(); // Limpar o buffer do scanner
                                    System.out.println("Nome do Autor/a");
                                    book.setAuthor(scanner.nextLine());
                                    scanner.nextLine(); // Limpar o buffer do scanner
                                    System.out.println("Nome da editora");
                                    book.setPublishe(scanner.nextLine());
                                    scanner.nextLine(); // Limpar o buffer do scanner
                                    System.out.println("Categoria");
                                    book.setCategory(scanner.nextLine());
                                    scanner.nextLine(); // Limpar o buffer do scanner
                                    System.out.println("Data de lançamento aaaa/m/dd");
                                    book.setReleaseDate(LocalDate.of(scanner.nextInt(),scanner.nextInt() ,scanner.nextInt() ));
                                    scanner.nextLine(); // Limpar o buffer do scanner
                                    userBo.addBookList(userCache.getId(), book);
                                    
                                    break;
                                case 2:
                                    limparTela();
                                    System.out.println("Opção escolhida: Listar Livros");
                                    LinkedListDouble<Book> userBooks = userBo.listUserBook(userCache.getId());
                                    for(int i = userBooks.getSize(); i > 0; i--){
                                        userBooks.peekFirst().getTitle();
                                        System.out.print("Livro : ");
                                        System.out.println(userBooks.peekFirst().getTitle());
                                        System.out.println("----------------------------");
                                        userBooks.removeFirst();
                                    }
                                    break;
                                case 3:
                                    limparTela();
                                    System.out.println("Opção escolhida: Adicionar avaliação");
                                    System.out.println("Busque o livro pelo nome");
                                    Book bookAux = bookBo.findBookByName(scanner.nextLine());
                                    scanner.nextLine();//limpando buffer
                                    System.out.println("Adicione uma avliação de 0 a 5");
                                    userBo.addAvaliation(scanner.nextInt(), userCache.getId(), bookAux.getId());
                                    // Implemente a lógica de remoção de livro aqui
                                    break;
                                case 4:
                                    limparTela();
                                    System.out.println("Opção escolhida: Marca página");
                                    System.out.println("Busque o livro pelo nome");
                                    bookAux = bookBo.findBookByName(scanner.nextLine());
                                    scanner.nextLine();//limpando buffer
                                    System.out.println("Qual foi a ultima pagina lida?");
                                    userBo.bookmark(scanner.nextInt(), userCache.getId(), bookAux.getId());
                                    break;
                                case 5:
                                    limparTela();
                                    System.out.println("Opção escolhida: Visualizar informações pessoais sobre o livro");
                                    System.out.println("Busque o livro pelo nome");
                                    bookAux = bookBo.findBookByName(scanner.nextLine());
                                    scanner.nextLine();//limpando buffer
                                    System.out.print("Quantidade de paginas lidas :");
                                    System.out.println(userBookDAO.readBook(bookAux.getId()).getPagesRead());
                                    System.out.print("Avaliação do livro :");
                                    System.out.println(userBookDAO.readBook(bookAux.getId()).getRating());
                                    break;
                                default:
                                    limparTela();
                                    System.out.println("Opção inválida. Tente novamente.");
                                    break;
                            }
                        }
                    }
                
                    break;
                case 3:
                    limparTela();
                    System.out.println("Saindo do programa...");
                    sair = true;
                    break;
                default:
                    limparTela();
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Cadastrar");
        System.out.println("2. Entrar");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }
    public static void exibirMenuLogado() {
        System.out.println("===== MENU LOGADO =====");
        System.out.println("1. Cadastrar livro");
        System.out.println("2. Listar livros");
        System.out.println("3. Adicionar avaliação do livro");
        System.out.println("4. Marca Página");
        System.out.println("5. Ver dados pessoais sobre o book");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (Exception ex) {
            System.out.println("Erro ao limpar a tela: " + ex.getMessage());
        }
    }
}
