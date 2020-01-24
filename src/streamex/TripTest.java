package streamex;

import java.util.ArrayList;
import java.util.List;

public class TripTest {
    public static void main(String[] args) {
        TripCustomer customer1 = new TripCustomer("A", 10, 10000);
        TripCustomer customer2 = new TripCustomer("B", 15, 15000);
        TripCustomer customer3 = new TripCustomer("C", 20, 20000);

        List<TripCustomer> list = new ArrayList<>();
        list.add(customer1);
        list.add(customer2);
        list.add(customer3);

        System.out.println(list);
        System.out.println();

        list.stream().map(TripCustomer::getName).forEach(System.out::println);
        int total = list.stream().mapToInt(TripCustomer::getPrice).sum();
        System.out.println(total);
        System.out.println();

        list.stream().filter(c -> c.getAge() > 10).map(TripCustomer::getName).sorted().forEach(System.out::println);
    }
}
