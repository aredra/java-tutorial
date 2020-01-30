package coffeeDecorator;

public class CoffeeTest {
    public static void main(String[] args) {
        Coffee americano = new KenyaBean();
        americano.brewing();

        Coffee latte = new Milk(new KenyaBean());
        latte.brewing();

        Coffee mocha = new Mocha(new Milk(new KenyaBean()));
        mocha.brewing();

        Coffee eti = new Mocha(new Milk(new EtiopiaBean()));
        eti.brewing();
    }
}
