public class SearchController {
    private PayRoll payRollSys;
    private SearchGUI searchGUI;

    public SearchController(PayRoll payRollSys) {
        this.payRollSys = payRollSys;
        this.searchGUI = new SearchGUI(this);
    }

    public Salesman searchSalesRepByName(String name) {
        return payRollSys.searchSalesRepByName(name);
    }
}
