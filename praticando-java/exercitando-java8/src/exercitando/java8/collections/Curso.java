package exercitando.java8.collections;

import java.util.*;

public class Curso {

    private String nome;
    private String instrutor;
    private List<Aula> aulas = new ArrayList<>();
//    LinkedList é útil para adicionar elementos no começo da Lista
//    private List<Aula> aulas = new LinkedList<>();
    private Set<Aluno> alunos = new HashSet<>();

    public Curso (String nome, String instrutor) {
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public List<Aula> getAulas() {
        return Collections.unmodifiableList(aulas);
    }
    public void addAula(Aula aula) {
        this.aulas.add(aula);
    }

    public Set<Aluno> getAlunos() {
        return Collections.unmodifiableSet(alunos);
    }
    public void matricula(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public int getTempoTotal() {
        return this.aulas.stream()
                .mapToInt(Aula::getCargaHoraria)
                .sum();
    }

    @Override
    public String toString() {
        return "[Curso: " + this.nome + ", tempo total: "
                + getTempoTotal() + ", " + "aulas: " + this.aulas + "]";
    }

    public boolean estaMatriculado(Aluno aluno) {
        return this.alunos.contains(aluno);
    }

    public Aluno buscaMatriculado(int numeroMatricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getNumeroMatricula() == numeroMatricula) {
                return aluno;
            }
        }
        throw  new NoSuchElementException("Matrícula " + numeroMatricula + " não encontrada.");
    }
}
