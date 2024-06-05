import java.util.*;

import java.time.LocalDate;
import java.math.BigDecimal;
public class SortExample {
    public static void main(String[] args) {
        Portfolio p[] = new Portfolio[3];
        p[0] = new Portfolio("sarah", LocalDate.of(2022, 10, 9), new BigDecimal("10"));
        p[1] = new Portfolio("rachel", LocalDate.of(2022, 10, 9), new BigDecimal("20"));
        p[2] = new Portfolio("tom", LocalDate.of(2005, 5, 5), new BigDecimal("15"));

    
        Arrays.sort(p, new Sort());

        for (int i =0; i< p.length; i++) {
            System.out.println(p[i]);
        }
    }
}
