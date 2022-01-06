package exercitando.java8.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CursoComAlunoMain {
    public static void main(String[] args) {

        Curso curso = new Curso("Collections", "Paulo Silveira");
        curso.addAula(new Aula("Set", 20));
        curso.addAula(new Aula("List", 25));
        curso.addAula(new Aula("Map", 23));

        Aluno aluno1 = new Aluno("Rodrigo Turini", 34762);
        Aluno aluno2 = new Aluno("Guilherme Silveira", 23981);
        Aluno aluno3 = new Aluno("Mauricio Aniche", 19382);

        curso.matricula(aluno1);
        curso.matricula(aluno2);
        curso.matricula(aluno3);

//        curso.getAlunos().forEach(aluno -> System.out.println(aluno));
//        Faz a mesma coisa que o Lambda
        curso.getAlunos().forEach(System.out::println);

        System.out.println("O aluno " + aluno1 + " está matriculado? " + curso.estaMatriculado(aluno1));

        Aluno turini = new Aluno("Rodrigo Turini", 34762);
        System.out.println("Esse turini está matriculado? " + aluno1.equals(turini));
        System.out.println(aluno1.hashCode() == turini.hashCode());

        Set<Aluno> alunosSet = curso.getAlunos();
        Iterator<Aluno> iterador = alunosSet.iterator();
        while(iterador.hasNext()) {
           Aluno alunoIterado = iterador.next();
           System.out.println("Iterador: " + alunoIterado);
        }

        Iterator<Aluno> alunoInterado = alunosSet.iterator();
        while(alunoInterado.hasNext()) {
            Aluno aluno = alunoInterado.next();
            System.out.println(aluno);
        }

    }
}
