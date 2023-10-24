import java.text.NumberFormat;

public class DepartmentChiefHandler implements RaiseHandler{
    private RaiseHandler nextHandler;
    @Override
    public void setNextHandler(RaiseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void processRaiseRequest(double amount) {
        double numericValue = amount * 100;
        String formattedPercentage = String.format("%.1f%%", numericValue);
        System.out.println("Dept. Chief received raise request of " + formattedPercentage);
        if (amount > 0.02 && amount <= 0.05) {
            System.out.println("Department Chief: Raise of " + formattedPercentage + " approved.\n");
        } else if (nextHandler != null) {
            System.out.println("Dept. Chief: Request " + formattedPercentage + " out of bounds, transferring to CEO.\n");
            nextHandler.processRaiseRequest(amount);
        } else {
            System.out.println("Department Chief: Unable to approve raise request.");
        }
    }
}
