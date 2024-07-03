import java.util.Comparator;

public class SalesmanIDComparator implements Comparator<SalesmanModel> {
    public int compare(SalesmanModel s1, SalesmanModel s2) {
        return s1.getSalesmanStaffID().compareTo(s2.getSalesmanStaffID());
    }
}

