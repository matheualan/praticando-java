package minhas.praticas;

import java.util.Scanner;

public class Tabuada {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o número que deseja a tabuada: ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.println();

        for(int i = 1; i <= 10; i++) {
            int resultado = num * i;
            System.out.println(num + " x " + i + " = " + resultado);
        }
        System.out.println();

        for(int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
        sc.close();
    }
}
