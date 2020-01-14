package interfaceSchedule;

public class BubbleSort implements Sort {
    @Override
    public void ascending() {
        System.out.println("BubbleSort Ascending");
    }

    @Override
    public void descending() {
        System.out.println("BubbleSort Descending");
    }

    @Override
    public void description() {
        Sort.super.description();
        System.out.println("BubbleSort");
    }
}
