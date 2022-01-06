package exercitando.java8.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AulaTeste {
    public static void main(String[] args) {

//        Aula aula1 = new Aula("Spring Boot", "20");
//        Aula aula2 = new Aula("Amazon Web Service", "60");
//        Aula aula3 = new Aula("Java Básico", "40");

        List<Aula> aulas = new ArrayList<>();
        aulas.add(new Aula("ArrayList", 20));
        aulas.add(new Aula("Collections", 60));
        aulas.add(new Aula("Lambda", 40));

        System.out.println(aulas);
        Collections.sort(aulas);
        System.out.println(aulas);

        aulas.sort(Comparator.comparing(Aula::getCargaHoraria));
        System.out.println(aulas);

    }
}
