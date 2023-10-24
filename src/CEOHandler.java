import java.text.NumberFormat;

public class CEOHandler implements RaiseHandler{
    @Override
    public void setNextHandler(RaiseHandler nextHandler) {
        // last handler in chain
    }

    @Override
    public void processRaiseRequest(double amount) {
        double numericValue = amount * 100;
        String formattedPercentage = String.format("%.1f%%", numericValue);
        System.out.println("CEO: Raise of " + formattedPercentage + " approved");
    }
}
