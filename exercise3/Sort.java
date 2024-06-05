import java.util.Comparator;

public class Sort implements Comparator<Date> {
    @Override
    public int compare (Date d1, Date d2) {
        
        return Comparator.comparing(Date::getDate).compare(p1,p2);
    }
}
