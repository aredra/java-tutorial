package interfaceSchedule;

public class RoundRobin implements Scheduler {
    @Override
    public void getNextCall() {
        System.out.println("RoundRobin getNextCall");
    }

    @Override
    public void sendCallToAgent() {
        System.out.println("RoundRobin sendCallToAgent");
    }
}
