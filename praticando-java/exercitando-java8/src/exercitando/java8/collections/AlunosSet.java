package exercitando.java8.collections;

import java.util.HashSet;
import java.util.Set;

public class AlunosSet {
    public static void main(String[] args) {

        Set<String> alunos = new HashSet<>();
        alunos.add("Matheus Alan");
        alunos.add("Paulo Silveira");
        alunos.add("Loiane Growner");
        alunos.add("Nélio Alves");
        alunos.add("Gustavo Guanabara");
        alunos.add("Gustavo Guanabara"); //Set nao permite dados duplicados

        System.out.println(alunos.size());
        alunos.remove("Gustavo Guanabara");
        System.out.println(alunos);

//        FOREACH
//        for (String aluno : alunos) {
//            System.out.println(aluno);
//        }

//        LAMBDA
//        alunos.forEach(aluno -> System.out.println(aluno));

//        METHOD REFERENCE
        alunos.forEach(System.out::println);

        System.out.println("Resultado da Busca: " + alunos.contains("MatheuS Alan"));


    }
}
