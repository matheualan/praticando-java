package exercitando.java8.collections;

public class Aula implements Comparable<Aula> {

    private String titulo;
    private int cargaHoraria;

    public Aula(String titulo, int cargaHoraria) {
        this.titulo = titulo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public String toString() {
        return "[Aula: " + this.titulo +
                " - " + this.cargaHoraria + " min]";
    }

    @Override
    public int compareTo(Aula outraAula) {
        return this.titulo.compareTo(outraAula.titulo);
    }

}
