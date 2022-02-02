package packs.formatacaoNumeros;

/**
 * @author Matheus Alan
 * @version 1.0
 */

import java.text.NumberFormat;
import java.util.Locale;

public class MethodsNumberFormat {
    public static void main(String[] args) {

        Locale localeBR = new Locale("pt", "BR");

        int inteiro = 25000000;
        double dinheiro = 5550000;
        float percentual = 0.104f;

        NumberFormat getInstance = NumberFormat.getInstance(); //inteiro
        NumberFormat numberInstance = NumberFormat.getNumberInstance(localeBR); //numberFormat
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(localeBR); //dinheiro
        NumberFormat percentInstance = NumberFormat.getPercentInstance(localeBR); //percentual

        System.out.println("Antes: " + inteiro);
        System.out.println("Depois: " + getInstance.format(inteiro));

        System.out.println("\nAntes: " + inteiro);
        System.out.println("Depois: " + numberInstance.format(inteiro));

        System.out.println("\nAntes: " + dinheiro);
        System.out.println("Depois: " + currencyInstance.format(dinheiro));

        System.out.println("\nAntes: " + percentual);
        System.out.println("Depois: " + percentInstance.format(percentual));
    }

}
