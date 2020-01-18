package generic;

public class GenericPrinterTest {
    public static void main(String[] args) {
        //T변수 선언안하고도 쓸수 있음
        //GenericPrinter plasticGenericPrinter = new GenericPrinter<>();
        GenericPrinter<Plastic> plasticGenericPrinter = new GenericPrinter<>();

        Plastic material = new Plastic();
        plasticGenericPrinter.setMaterial(material);
        plasticGenericPrinter.print();
        System.out.println(plasticGenericPrinter.toString());
    }
}
