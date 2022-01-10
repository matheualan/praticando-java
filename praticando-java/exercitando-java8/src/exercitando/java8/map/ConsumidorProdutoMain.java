package exercitando.java8.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumidorProdutoMain {
    public static void main(String[] args) {

        Consumidor consumidor1 = new Consumidor("José Carlos", "123");
        Consumidor consumidor2 = new Consumidor("AlphaCom", "321");

        Produto produto1 = new Produto(101, "Notebook Asus VivoBook", 3500.0);
        Produto produto2 = new Produto(102, "Samsung Galaxy A10", 800.0);
        Produto produto3 = new Produto(103, "Adaptador para Iphone", 5000.0);
        Produto produto4 = new Produto(104, "Teclado Razer", 1000.0);

        List<Produto> listaConsumidor1 = new ArrayList<>();
        listaConsumidor1.add(produto1);
        listaConsumidor1.add(produto2);
        List<Produto> listaConsumidor2 = new ArrayList<>();
        listaConsumidor2.add(produto3);
        listaConsumidor2.add(produto4);

        Map<Consumidor, List<Produto>> map = new HashMap<>();
        map.put(consumidor1, listaConsumidor1);
        map.put(consumidor2, listaConsumidor2);

        for(Map.Entry<Consumidor, List<Produto>> entry : map.entrySet()) {
            System.out.println("Cliente: " + entry.getKey().getNome());
            for(Produto produto : entry.getValue()) {
                System.out.println("Item: " + produto.getNome());
            }
            System.out.println();
        }

    }
}
