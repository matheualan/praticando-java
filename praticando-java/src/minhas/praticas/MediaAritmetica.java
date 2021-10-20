package minhas.praticas;

import java.util.Scanner;

public class MediaAritmetica {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Informe a quantidade de números a ser tirado a média: ");
        int qtdNumeros = Integer.parseInt(sc.nextLine());
        double[] numeros = new double[qtdNumeros];

        System.out.println();
        double media = 0;
        double soma = 0;
        for (int i = 0; i < qtdNumeros; i++) {
            System.out.print("Digite o " + (i+1) + "º número: ");
            soma += numeros[i] = Double.parseDouble(sc.nextLine());
        }

        System.out.println();
        for(Double numbs : numeros) {
            System.out.print("Número: " + numbs + ", ");
        }

        System.out.println();
        media = soma / qtdNumeros;
        System.out.println("\nMédia dos números: " + media);

        sc.close();
    }
}
