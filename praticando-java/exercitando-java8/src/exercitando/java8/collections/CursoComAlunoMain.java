package exercitando.java8.collections;

public class CursoComAlunoMain {
    public static void main(String[] args) {

        Curso curso = new Curso("Collections", "Paulo Silveira");
        curso.addAula(new Aula("Set", 20));
        curso.addAula(new Aula("List", 25));
        curso.addAula(new Aula("Map", 23));

        Aluno aluno1 = new Aluno("Rodrigo Turini", 34762);
        Aluno aluno2 = new Aluno("Guilherme Silveira", 23981);
        Aluno aluno3 = new Aluno("Mauricio Aniche", 19382);

        curso.matricular(aluno1);
        curso.matricular(aluno2);
        curso.matricular(aluno3);

//        curso.getAlunos().forEach(aluno -> System.out.println(aluno));
//        Faz a mesma coisa que o Lambda
        curso.getAlunos().forEach(System.out::println);

        System.out.println("O aluno " + aluno1 + " está matriculado? " + curso.isMatriculado(aluno1));

        Aluno turini = new Aluno("Rodrigo Turini", 34762);
        System.out.println("Esse turini está matriculado? " + aluno1.equals(turini));
        System.out.println(aluno1.hashCode() == turini.hashCode());

//        LOOP USANDO ITERATOR
//        Set<Aluno> alunosSet = curso.getAlunos();
//        Iterator<Aluno> iterador = alunosSet.iterator();
//        while(iterador.hasNext()) {
//           Aluno alunoIterado = iterador.next();
//           System.out.println("Iterador: " + alunoIterado);
//        }

    }
}
