package minhas.praticas;

import java.util.Random;
import java.util.Scanner;

public class JogoDeDados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual o seu palpite? ");
        int palpite = Integer.parseInt(sc.nextLine());
        Random random = new Random();
        int dado = random.nextInt(6) + 1;

        if (dado == palpite) {
            System.out.println("ACERTOU !!!");
        } else {
            System.out.println("ERROU !!!");
        }

        System.out.println("Seu palpite foi: " + palpite);
        System.out.println("O valor do dado foi: " + dado);
    }
}