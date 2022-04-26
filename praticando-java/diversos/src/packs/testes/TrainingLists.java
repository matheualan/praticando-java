package packs.testes;

import java.util.ArrayList;
import java.util.List;

public class TrainingLists {
    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();

        nomes.add("Matheus");
        nomes.add("Eloyza");
        nomes.add("Bernardo");
        nomes.add("Miguel");
        nomes.add("Guilherme");

        System.out.println("Lista: " + nomes.toString() + "\nTamanho da Lista: " + nomes.size());
        nomes.size();
        nomes.remove(0);
        System.out.println("Lista: " + nomes.toString() + "\nTamanho da Lista: " + nomes.size());

        System.out.println(nomes.get(2));
        System.out.println(nomes.indexOf("Miguel"));

    }
}
