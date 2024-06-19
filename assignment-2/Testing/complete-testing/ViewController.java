import java.util.List;

public class ViewController {
    private PayRoll payRollSys;
    private ViewGUI viewGUI;

    public ViewController(PayRoll payRollSys) {
        this.payRollSys = payRollSys;
        this.viewGUI = new ViewGUI(this);
    }

    public List<Salesman> getAllSalesmen() {
        return payRollSys.getAllSalesmen();
    }
}

