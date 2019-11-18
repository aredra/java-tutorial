package beginJava;

public class Person {
    private int age;
    private String name;
    private boolean married;
    private int children = 0;

    public Person(int age, String name, boolean yn) {
        this.age = age;
        this.name = name;
        this.married = yn;
    }

    public void setAge(int age) {this.age = age;}
    public int getAge() {return this.age;}
    public void setName(String name) {this.name = name;}
    public String getName() {return this.name;}
    public void setMarried(boolean married) {this.married = married;}
    public boolean getMarried() {return this.married;}
    public void setChilren(int count) {this.children =count;}
    public int getChilren() {return this.children;}

    public void showPersonInfo() {
        System.out.println("age: " + this.age);
        System.out.println("name: " + this.name);
        System.out.println("married: " + this.married);
        System.out.println("children: " + this.children);
    }
}
