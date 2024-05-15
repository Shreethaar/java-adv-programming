
import java.util.Comparator;
import java.util.Map;

class FrequencyComparator implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        //return o2.getValue() - o1.getValue();
        return o2.getValue().compareTo(o1.getValue());
    }
    
}