package streamex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {
    public static void main(String[] args) {
        List<String> sList = new ArrayList<>();
        sList.add("A");
        sList.add("REF");
        sList.add("E");
        sList.add("D");
        sList.add("R");
        sList.add("A");

        Stream<String> stream = sList.stream();
        stream.forEach(el -> System.out.print(el+""));
        System.out.println();

        sList.stream().sorted().forEach(el -> System.out.println(el+""));
        System.out.println();

        sList.stream().map(String::length).forEach(System.out::println);
    }
}
