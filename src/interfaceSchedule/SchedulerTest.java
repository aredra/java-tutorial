package interfaceSchedule;

import java.io.IOException;

public class SchedulerTest {
    public static void main(String[] args) throws IOException {
        System.out.println("Select");
        System.out.println("R");
        System.out.println("L");
        System.out.println("P");

        int ch = System.in.read();
        Scheduler scheduler = null;

        if (ch =='R' || ch =='r') scheduler = new RoundRobin();
        else if (ch == 'L' || ch == 'l') scheduler = new RoundRobin();
        else if (ch == 'P' || ch == 'p') scheduler = new RoundRobin();
        else {
            System.out.println("Not Supported");
            return;
        }

        scheduler.getNextCall();
        scheduler.sendCallToAgent();
    }
}
