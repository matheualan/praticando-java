package exercitando.java8.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CursoList {
    public static void main(String[] args) {

        Curso cursos = new Curso("Collections Java", "Paulo Silveira");

//        List<Aula> aulas = cursos.getAulas();
//        System.out.println(aulas);
//        cursos.getAulas().add(new Aula("Collections", "20"));

        cursos.addAula(new Aula("Modelando Coleções", 25));
        cursos.addAula(new Aula("Criando uma Aula", 15));
        cursos.addAula(new Aula("Collections", 20));
        System.out.println(cursos.getAulas());

        List<Aula> aulasImutaveis = cursos.getAulas();
//        System.out.println(aulasImutaveis);
        List<Aula> aulas = new ArrayList<>(aulasImutaveis);
        Collections.sort(aulas);
        System.out.println(aulas);

        //referencia ao metodo dentro de Curso
        System.out.println(cursos.getTempoTotal());

        //implementado toString dentro de Curso
        System.out.println(cursos);

    }
}