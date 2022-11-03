package coffeeDecorator;

public class Milk extends Coffee{
    Coffee coffee;

    public Milk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void brewing() {
        coffee.brewing();
        System.out.println("adding milk");
    }
}
