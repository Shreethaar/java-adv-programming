
public class SearchController {
    private PayRollSystem payRollSys;
    private SearchGUI searchGUI;

    public SearchController(PayRollSystem payRollSys) {
        this.payRollSys = payRollSys;
        this.searchGUI = new SearchGUI(this);
    }

    public Salesman searchSalesRepByName(String name) {
        return payRollSys.searchSalesRepByName(name);
    }
}
