public interface RaiseHandler {
    void setNextHandler(RaiseHandler nextHandler);
    void processRaiseRequest(double amount);
}
