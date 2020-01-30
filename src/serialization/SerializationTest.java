package serialization;

import java.io.*;

class Person implements Serializable {
    String name;
    //직렬화 하지 마시오 transient
    transient String job;

    public Person(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return name +": "+job;
    }
}

public class SerializationTest {
    public static void main(String[] args) {
        Person person1 = new Person("Aredra", "Newbie");
        Person person2 = new Person("dev1", "slave");

        try (FileOutputStream fos = new FileOutputStream("output.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(person1);
            oos.writeObject(person2);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("output.dat");
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            Person p1 = (Person) ois.readObject();
            Person p2 = (Person) ois.readObject();

            System.out.println(p1);
            System.out.println(p2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
