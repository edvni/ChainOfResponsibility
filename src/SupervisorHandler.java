import java.text.NumberFormat;

public class SupervisorHandler implements RaiseHandler{
    private RaiseHandler nextHandler;
    @Override
    public void setNextHandler(RaiseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void processRaiseRequest(double amount) {
        double numericValue = amount * 100;
        String formattedPercentage = String.format("%.1f%%", numericValue);
        System.out.println("Supervisor received raise request of " + formattedPercentage);
        if (amount <= 0.02) {
            System.out.println("Supervisor: Raise of " + formattedPercentage + " approved.\n");
        } else if (nextHandler != null) {
            System.out.println("Supervisor: Request " + formattedPercentage + " out of bounds, transferring to Dept. Chief.\n");
            nextHandler.processRaiseRequest(amount);
        } else {
            System.out.println("Supervisor: Unable to approve raise request.");
        }
    }
}
