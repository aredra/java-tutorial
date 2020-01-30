package coffeeDecorator;

public class Milk extends Decorator{
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.println("adding milk");
    }
}
