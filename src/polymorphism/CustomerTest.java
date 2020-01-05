package polymorphism;

import java.util.ArrayList;

public class CustomerTest {
    public static void main(String[] args) {
        Customer customer1 = new VIPCustomer(10010, "customer1", 8703);
        Customer customer2 = new GoldCustomer(10020, "customer2");
        Customer customer3 = new GoldCustomer(10030, "customer3");
        Customer customer4 = new Customer(10040, "customer4");
        Customer customer5 = new Customer(10050, "customer5");
        ArrayList<Customer> customers = new ArrayList<Customer>();

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

        for (Customer customer : customers) {
            int pay = customer.calcPrice(100000);
            System.out.println(customer.customerName + " pay " +pay);
            System.out.println(customer.showCustomerInfo());
        }
    }
}
