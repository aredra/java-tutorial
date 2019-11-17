package beginJava;

public class Person {
    private int age;
    private String name;
    private boolean married;
    private int chilren = 0;

    public void setAge(int age) {this.age = age;}
    public int getAge() {return this.age;}
    public void setName(String name) {this.name = name;}
    public String getName() {return this.name;}
    public void setMarried(boolean married) {this.married = married;}
    public boolean getMarried() {return this.married;}
    public void setChilren(int count) {this.chilren =count;}
    public int getChilren() {return this.chilren;}

    public void showPersonInfo() {
        System.out.println("age: " + this.age);
        System.out.println("name: " + this.name);
        System.out.println("married: " + this.married);
        System.out.println("children: " + this.chilren);
    }
}
