package streamex;

import java.util.stream.Stream;

public class TripCustomer {
    private String name;
    private int age;
    private int price;

    public TripCustomer(String name, int age, int price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }

    @Override
    public String toString() {
        return name+": "+age+", "+price;
    }

    public String getName() {
        return name;
    }

    public void setName(String num) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
