package exercitando.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaJava8 {
    public static void main(String[] args) {

//        Para implementar uma função Lambda é necessário seguir o padrão SAM(Single Abstract Method)
//        onde a interface deve conter apenas 1 método para que o Java possa criar a função Lambda.

//        sem lambda
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Sem Lambda!");
            }
        }).run();
//        com lambada
        new Thread(() -> System.out.println("Com Lambda!")).run();

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> par = new ArrayList<>();
        List<Integer> impar = new ArrayList<>();

        numeros.forEach((number) -> {
            if (number % 2 == 0) {
                par.add(number);
            } else {
                impar.add(number);
            }
        });
        System.out.println(impar);
        System.out.println(par);

    }
}
