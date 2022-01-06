package exercitando.java8.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapJava8 {
    public static void main(String[] args) {

//        Map<String, String> map = new HashMap<>();
//        map.put("User", "Maria");
//        map.put("Phone", "27469831");
//        for (String key : map.keySet()) {
//            System.out.println("Key = " + key + " / Value = " + map.get(key));
//        }

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        System.out.print("Enter file full path: ");
        String path = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(",");

                String name = fields[0];
                Integer votes = Integer.parseInt(fields[1]);

                if (map.get(name) == null) {
                    map.put(name, votes);
                } else {
                    map.put(name, votes + map.get(name));
                }
//                map.merge(name, votes, Integer::sum);

                line = br.readLine();
            }

            for (String key : map.keySet()) {
                System.out.println(key + " : " + map.get(key));
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        scanner.close();

    }
}
