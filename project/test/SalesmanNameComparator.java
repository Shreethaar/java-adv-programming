import java.util.Comparator;

public class SalesmanNameComparator implements Comparator<SalesmanModel> {
    public int compare(SalesmanModel s1, SalesmanModel s2) {
        return s1.getSalesmanFullName().compareTo(s2.getSalesmanFullName());
    }
}



