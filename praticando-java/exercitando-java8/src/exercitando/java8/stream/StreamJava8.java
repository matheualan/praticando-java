package exercitando.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamJava8 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 1, 4, 4, 6);
        System.out.println("lista original: " + numbers);

        List<Integer> result = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("\ndistinct: " + result);

        List<Integer> skipFilterLimit = numbers.stream()
                .skip(3)
                .filter(number -> number % 2 == 0)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("\nskip, filter, limit: "+ skipFilterLimit);

        Map<Integer, List<Integer>> mapa = numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.groupingBy(number -> number % 3));
        System.out.println("\nmap: " + mapa);

        String joiningValueOf = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("\nstring::valueof, joining: " + joiningValueOf);

        long count = numbers.stream()
                .map(number -> number * 2)
                .count();
        System.out.println("\ncount: " + count);

    }
}
