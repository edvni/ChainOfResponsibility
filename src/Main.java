public class Main {
    public static void main(String[] args) {
        RaiseHandler supervisor = new SupervisorHandler();
        RaiseHandler departmentChief = new DepartmentChiefHandler();
        RaiseHandler ceo = new CEOHandler();

        supervisor.setNextHandler(departmentChief);
        departmentChief.setNextHandler(ceo);

        System.out.println("----New raise request----");
        double raiseAmount1 = 0.017; // Supervisor should approve
        supervisor.processRaiseRequest(raiseAmount1);

        System.out.println("----New raise request----");
        double raiseAmount2 = 0.047;  // Department Chief should approve
        supervisor.processRaiseRequest(raiseAmount2);

        System.out.println("----New raise request----");
        double raiseAmount3 = 0.12;  // CEO should approve
        supervisor.processRaiseRequest(raiseAmount3);

    }
}
