import java.util.Scanner;

import SRC.Model.BO.BookBO;
import SRC.Model.BO.UserBO;
import SRC.Model.VO.User;

public class MinhaLeitura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        UserBO userBo = new UserBO();
        BookBO bookBo =  new BookBO();

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
