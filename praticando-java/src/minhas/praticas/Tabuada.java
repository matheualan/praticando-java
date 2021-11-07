package minhas.praticas;

import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("=====================================================" +
                "\nSelecione a operação que deseja saber a tabuada: " +
                "\n1 - Adição" +
                "\n2 - Subtração" +
                "\n3 - Multiplicação" +
                "\n4 - Divisão");
        System.out.println("=====================================================");
        try {
            int operadorTabuada = Integer.parseInt(sc.nextLine());

            switch (operadorTabuada) {
                case 1:
                    System.out.print("=====================================================" +
                            "\nDigite o número que deseja o cálculo da tabuada: ");
                    int numeroTabuada = Integer.parseInt(sc.nextLine());
                    System.out.println("\nADIÇÃO: ");
                    for (int i = 1; i <= 10; i++) {
                        int resultado = numeroTabuada + i;
                        System.out.println(numeroTabuada + " + " + i + " = " + resultado);
                    }
                    sc.close();
                    break;

                case 2:
                    System.out.print("=====================================================" +
                            "\nDigite o número que deseja o cálculo da tabuada: ");
                    numeroTabuada = Integer.parseInt(sc.nextLine());
                    System.out.println("\nSUBTRAÇÃO: ");
                    for (int i = numeroTabuada + 10; i >= numeroTabuada; i--) {
                        int resultado = i - numeroTabuada;
                        System.out.println(i + " - " + numeroTabuada + " = " + resultado);
                    }
                    sc.close();
                    break;

                case 3:
                    System.out.print("=====================================================" +
                            "\nDigite o número que deseja o cálculo da tabuada: ");
                    numeroTabuada = Integer.parseInt(sc.nextLine());
                    System.out.println("\nMULTIPLICAÇÃO: ");
                    for (int i = 1; i <= 10; i++) {
                        int resultado = numeroTabuada * i;
                        System.out.println(numeroTabuada + " x " + i + " = " + resultado);
                    }
                    sc.close();
                    break;

                case 4:
                    System.out.print("=====================================================" +
                            "\nDigite o número que deseja o cálculo da tabuada: ");
                    numeroTabuada = Integer.parseInt(sc.nextLine());
                    System.out.println("\nDIVISÃO: ");
                    for (int i = numeroTabuada * 10; i >= 1; i -= numeroTabuada) {
                        int resultado = i / numeroTabuada;
                        System.out.println(i + " / " + numeroTabuada + " = " + resultado);
                    }
                    sc.close();
                    break;

                default:
                    System.err.println("Entrada inválida, reinicie o programa.");
                    sc.close();
            }
        } catch (Exception e) {
            System.err.print("Entrada inválida, reinicie o programa.");
        }
        sc.close();

    }
}
