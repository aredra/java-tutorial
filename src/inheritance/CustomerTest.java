package inheritance;

public class CustomerTest {
    public static void main(String[] args) {
        Customer aredra = new Customer(10010, "Aredra");
        aredra.bonusPoint = 1000;
        System.out.println(aredra.showCustomerInfo());

        VIPCustomer rnswn = new VIPCustomer(10020, "rnswn");
        rnswn.bonusPoint = 100000;
        System.out.println(rnswn.showCustomerInfo());

        Customer dev1 = new VIPCustomer(10030, "dev1");
        dev1.bonusPoint = 1000000;

        System.out.println(aredra.calcPrice(10000));
        System.out.println(rnswn.calcPrice(10000));
        System.out.println(dev1.calcPrice(10000));
    }
}
