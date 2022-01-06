package minhas.praticas;

import java.util.Scanner;

public class MenuSwitchCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - HBO\n" +
                "2 - TELECINE\n" +
                "3 - Disney Channel\n" +
                "4 - ESPN\n" +
                "5 - Discovery\n");
        System.out.print("Digite sua opção: ");
        int opcao = Integer.parseInt(sc.nextLine());

        switch (opcao) {
            case 1:
                System.out.println("HBO SELECIONADO");
                break;
            case 2:
                System.out.println("TELECINE SELECIONADO");
                break;
            case 3:
                System.out.println("Disney Channel SELECIONADO");
                break;
            case 4:
                System.out.println("ESPN SELECIONADO");
                break;
            case 5:
                System.out.println("Discovery SELECIONADO");
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA, CONSULTE O MENU.");
        }
        sc.close();
    }
}
