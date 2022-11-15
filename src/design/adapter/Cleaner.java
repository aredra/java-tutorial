package design.adapter;

public class Cleaner implements Electronic220V {
    @Override
    public void connect() {
        System.out.println("Cleaner use 220V");
    }
}
