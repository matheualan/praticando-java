package exercitando.java8.map;

public class Produto {

    private Integer serialNumber;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(Integer serialNumber, String nome, double preco) {
        this.serialNumber = serialNumber;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
