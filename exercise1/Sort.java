import java.util.*;
public class Sort implements Comparator <Portfolio> {
    @Override 
    public int compare(Portfolio p1, Portfolio p2) {
        if (p1.inceptionDate.compareTo(p2.inceptionDate) != 0) {
            return p1.inceptionDate.compareTo(p2.inceptionDate);
        }
        else if (p1.value.compareTo(p2.value)!=0) {
            return p1.value.compareTo(p2.value);
        }
        else {
            return p1.owner.compareTo(p2.owner);
        }
    }
}