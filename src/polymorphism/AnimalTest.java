package polymorphism;

import java.util.ArrayList;

class Animal {
    public void move() {
        System.out.println("animal is moving");
    }
}

class Human extends Animal {
    @Override
    public void move() {
        System.out.println("Human is moving");
    }
    public void readBook() {
        System.out.println("Human is reading a book");
    }
}

class Tiger extends Animal {
    @Override
    public void move() {
        System.out.println("Tiger is moving");
    }
    public void hunting() {
        System.out.println("Tiger is hunting");
    }
}

class Eagle extends Animal {
    @Override
    public void move() {
        System.out.println("Eagle is moving");
    }
    public void flying() {
        System.out.println("Eagle is flying high");
    }
}

public class AnimalTest {
    public static void main(String[] args) throws Exception {
        Animal hAnimal = new Human();
        Animal tAnimal = new Tiger();
        Animal eAnimal = new Eagle();

        AnimalTest test = new AnimalTest();
        test.moveAnimal(hAnimal);
        test.moveAnimal(tAnimal);
        test.moveAnimal(eAnimal);

        ArrayList<Animal> animalList = new ArrayList<Animal>();
        animalList.add(hAnimal);
        animalList.add(tAnimal);
        animalList.add(eAnimal);

        test.testDownCasting(animalList);

        for (Animal animal : animalList) {
            animal.move();
        }
    }
    //DownCasting && instanceof
    private void testDownCasting(ArrayList<Animal> list) throws Exception {
        for (Animal animal : list) {
            if (animal instanceof Human) {
                Human human = (Human) animal;
                human.readBook();
            } else if (animal instanceof Tiger) {
                Tiger tiger = (Tiger) animal;
                tiger.hunting();
            } else if (animal instanceof Eagle) {
                Eagle eagle = (Eagle) animal;
                eagle.flying();
            } else throw new Exception("Error!");
        }
    }
    public void moveAnimal(Animal animal) {
        animal.move();
    }
}
