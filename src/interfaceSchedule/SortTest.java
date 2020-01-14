package interfaceSchedule;

import java.io.IOException;

public class SortTest {
    public static void main(String[] args) throws IOException {
        System.out.println("Select");
        System.out.println("B");
        System.out.println("H");
        System.out.println("Q");

        int ch = System.in.read();
        Sort sort = null;

        if (ch =='B' || ch =='v') sort = new BubbleSort();
        else if (ch == 'H' || ch == 'h') sort = new HeaSort();
        else if (ch == 'Q' || ch == 'q') sort = new QuickSort();
        else {
            System.out.println("Not Supported");
            return;
        }

        sort.ascending();
        sort.descending();
        sort.description();
    }
}
