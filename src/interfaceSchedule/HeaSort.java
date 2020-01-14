package interfaceSchedule;

public class HeaSort implements Sort {
    @Override
    public void ascending() {
        System.out.println("HeaSort Ascending");
    }

    @Override
    public void descending() {
        System.out.println("HeaSort Descending");
    }

    @Override
    public void description() {
        Sort.super.description();
        System.out.println("HeaSort");
    }
}
