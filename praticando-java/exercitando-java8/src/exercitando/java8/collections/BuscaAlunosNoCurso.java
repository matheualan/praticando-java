package exercitando.java8.collections;

public class BuscaAlunosNoCurso {
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

        System.out.println("Aluno com matrícula 34762?");
        Aluno aluno = curso.findByMatricula(34762);
        System.out.println("Aluno: " + aluno);

        System.out.println("O aluno(a) " + aluno2 + " está matriculado(a)? " + curso.isMatriculado(aluno2));

    }
}
