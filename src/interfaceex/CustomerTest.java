package interfaceex;

public class CustomerTest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.buy();
        customer.sell();
        customer.order();

        Buy buyer = new Customer();
        buyer.buy();
        buyer.order();

        Sell seller = new Customer();
        seller.sell();
        seller.order();
    }
}
