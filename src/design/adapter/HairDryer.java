package design.adapter;

public class HairDryer implements Electronic110V {
    @Override
    public void powerOn() {
        System.out.println("HairDryer use 110V");
    }
}
