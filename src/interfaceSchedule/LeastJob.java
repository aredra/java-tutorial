package interfaceSchedule;

public class LeastJob implements Scheduler {
    @Override
    public void getNextCall() {
        System.out.println("LeastJob getNextCall");
    }

    @Override
    public void sendCallToAgent() {
        System.out.println("LeastJob getNextCall");
    }
}
