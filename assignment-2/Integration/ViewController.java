import java.util.Map;

public class ViewController {
    private PayRoll payRollSys;
    private ViewGUI viewGUI;

    public ViewController(PayRoll payRollSys) {
        this.payRollSys = payRollSys;
        this.viewGUI = new ViewGUI(this);
    }

    public Map<String, Salesman> getAllSalesmen() {
        return payRollSys.getSalesRepInfo();
    }
}

