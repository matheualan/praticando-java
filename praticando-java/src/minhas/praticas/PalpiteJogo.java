package minhas.praticas;

import javax.swing.*;
import java.util.Scanner;

public class PalpiteJogo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        JOptionPane.showMessageDialog(null, "BEM VINDO AO JOGO DE PALPITE");

        int num1 = Integer.parseInt(JOptionPane.showInputDialog
                ("Digite o palpite do primeiro time: "));

        int num2 = Integer.parseInt(JOptionPane.showInputDialog
                ("Digite o palpite do segundo time: "));

        double palpite1 = Math.random() * 5;
        double palpite2 = Math.random() * 5;
        int palp1 = (int) palpite1;
        int palp2 = (int) palpite2;

        if (palp1 > palp2) {
            System.out.println("TIME 1 VENCEU");
            JOptionPane.showMessageDialog(null, "TIME 1 VENCEU !!!" +
                    "\nPlacar: "+ palp1 + " x " + palp2 +
                    "\nTime 1: [" + palp1 + "] / Time 2: [" + palp2 + "]");
        } else if (palp2 > palp1) {
            JOptionPane.showMessageDialog(null, "TIME 2 VENCEU !!!" +
                    "\nPlacar: "+ palp2 + " x " + palp1 +
                    "\nTime 2: [" + palp2 + "] / Time 1: [" + palp1 + "]");
        } else {
            JOptionPane.showMessageDialog(null, "EMPATE !!!" +
                    "\nPlacar: "+ palp1 + " x " + palp2 +
                    "\nTime 1: [" + palp1 + "] / Time 2: [" + palp2 + "]");
        }

//        JOptionPane.showConfirmDialog(null, "DESEJA CONTINUAR?");
    }
}
