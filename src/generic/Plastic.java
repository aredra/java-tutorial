package generic;

public class Plastic extends Meterial{
    public String toString() {
        return "material is plastic";
    }

    @Override
    public void doPrinting() {
        System.out.println("material plastic is printing");
    }
}
