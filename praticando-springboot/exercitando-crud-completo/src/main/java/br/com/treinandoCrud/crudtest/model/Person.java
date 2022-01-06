package br.com.treinandoCrud.crudtest.model;

import javax.persistence.*;

@Entity
@Table(name = "person_table")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Long id;
    @Column
    private String nome;
    @Column
    private String dataNascimento;
    @Column
    private String profissao;

    public Person() {
    }

    public Person(Long id, String name, String dataNascimento, String profissao) {
        this.id = id;
        this.nome = name;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        return "Person: " +
                "\nId = " + id +
                "\nNome = " + nome +
                "\nData de Nascimento = " + dataNascimento +
                "\nProfissão = " + profissao;
    }
}
