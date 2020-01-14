package interfaceSchedule;

public interface Sort {
    void ascending();
    void descending();
    default void description() {
        System.out.println("Algorithm");
    }
}
