package exercitando.java8.optional;

import java.util.Optional;

public class OptionalJava8 {
    public static void main(String[] args) {
        String numberString = "1995";
        String stringString = "Vai com tudo garoto!!!";
        converterEmNumero(numberString).ifPresent(number -> System.out.println(number));
//        Optional<Integer> numberConverted = converterEmNumero(numberString);
//        numberConverted.ifPresent(number -> System.out.println(number));

        System.out.println(converterEmNumero(stringString).orElse(5));
        System.out.println(converterEmNumero(stringString).orElseGet(() -> 5));

        System.out.println(converterEmNumero((stringString))
                .orElseThrow(() -> new NullPointerException("Campo vazio.")));
    }

    public static Optional<Integer> converterEmNumero(String numeroStr) {
        try {
            Integer integer = Integer.valueOf(numeroStr);
            return Optional.of(integer);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
