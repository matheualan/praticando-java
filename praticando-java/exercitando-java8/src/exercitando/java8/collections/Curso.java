package exercitando.java8.collections;

import java.util.*;

public class Curso {

    private String nome;
    private String instrutor;
    //    LinkedList é útil para adicionar elementos no começo da Lista
    private List<Aula> aulas = new ArrayList<>();
    private Set<Aluno> alunos = new HashSet<>();
    private Map<Integer, Aluno> matriculaAluno = new HashMap<>();

    public Curso(String nome, String instrutor) {
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

    public void matricular(Aluno aluno) {
        this.alunos.add(aluno);
        this.matriculaAluno.put(aluno.getNumeroMatricula(), aluno);
    }

    public boolean isMatriculado(Aluno aluno) {
        return this.alunos.contains(aluno);
    }

    public Aluno findByMatricula(int numeroMatricula) {
        if(!matriculaAluno.containsKey(numeroMatricula)) {
            throw new NoSuchElementException();
        }
        return matriculaAluno.get(numeroMatricula);
//        for (Aluno aluno : alunos) {
//            if (aluno.getNumeroMatricula() == numeroMatricula) {
//                return aluno;
//            }
//        }
//        throw new NoSuchElementException("Matrícula " + numeroMatricula + " não encontrada.");
    }
}
