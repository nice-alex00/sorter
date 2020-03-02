package util;

import java.util.Comparator;
import java.util.List;

public class Sorting implements Comparator<List<Object>> {

    @Override
    public int compare(List<Object> o1, List<Object> o2) {
        for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
            if (o1.get(i) instanceof Double && o2.get(i) instanceof Double) {
                double tmp = (Double) o2.get(i) - (Double) o1.get(i);
                if (tmp != 0)
                    return tmp > 0 ? -1 : 1;
            }
            if (o1.get(i) instanceof Double && o2.get(i) instanceof String) {
                return -1;
            }
            if (o1.get(i) instanceof String && o2.get(i) instanceof Double) {
                return 1;
            }
            if (o1.get(i) instanceof String && o2.get(i) instanceof String) {
                int tmp = ((String) o1.get(i)).compareToIgnoreCase((String) o2.get(i));
                if (tmp != 0)
                    return ((String) o1.get(i)).compareToIgnoreCase((String) o2.get(i));
            }
        }
        return o2.size() - o1.size();
    }
}
