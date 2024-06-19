import java.util.*;

public class SalesmanComparator implements Comparator<Salesman> {
    public int compare(Salesman salesman1, Salesman salesman2) {
        return salesman1.getSalesRepFullName().compareToIgnoreCase(salesman2.getSalesRepFullName());
    }
}
