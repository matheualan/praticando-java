package exercitando.java8.collections;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListJava8 {
    public static void main(String[] args) {

        ArrayList<String> listString = new ArrayList<>();
        String string1 = "Set";
        String string2 = "ArrayList";
        String string3 = "Map";

        listString.add(string1);
        listString.add(string2);
        listString.add(string3);
        System.out.println(listString);

//        listString.remove(0);
//        listString.remove(string3);
//        System.out.println(listString);

//        listString.add(string3);
        System.out.println();
        listString.forEach(string -> System.out.println("Aula: " + string));

//        System.out.println(listString.get(0));

        Collections.sort(listString);
        System.out.println("\n" + listString);

    }
}
