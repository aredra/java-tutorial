package interfaceSchedule;

public class PriorityAllocation implements Scheduler {
    @Override
    public void getNextCall() {
        System.out.println("PriorityAllocation getNextCall");
    }

    @Override
    public void sendCallToAgent() {
        System.out.println("PriorityAllocation getNextCall");
    }
}
