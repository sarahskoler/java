import java.time.LocalDate;
import java.util.*;
public class MergeDates {
    public static void main(String[]args) {
        
        List<LocalDate[]> dates = new ArrayList<>();
        dates.add(new LocalDate[]{LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 10)});
        dates.add(new LocalDate[]{LocalDate.of(2023, 3, 20), LocalDate.of(2023, 3, 21)});
        dates.add(new LocalDate[]{LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 10)});
        dates.add(new LocalDate[]{LocalDate.of(2023, 3, 15), LocalDate.of(2023, 3, 31)});
        dates.add(new LocalDate[]{LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 10)});
        dates.add(new LocalDate[]{LocalDate.of(2023, 8, 20), LocalDate.of(2023, 8, 31)});

        List<LocalDate[]> mergedDates = merge(dates);
        for (LocalDate[] interval : mergedDates) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static List<LocalDate[]> merge(List<LocalDate[]> dates) {
        
        dates.sort(Comparator.comparing(dateRange -> dateRange[0]));

        List<LocalDate[]> finalList = new ArrayList<>();
        LocalDate start = null;
        LocalDate end = null;

        for (LocalDate[] interval : dates) {
            LocalDate intervalStart = interval[0];
            LocalDate intervalEnd = interval[1];

            if (start == null) {
                start = intervalStart;
                end = intervalEnd;
            }
            else if (intervalStart.isAfter(end) || intervalStart.isEqual(end.plusDays(1))) {
                finalList.add(new LocalDate[] {start, end});
                start = intervalStart;
                end = intervalEnd;
            }
            else if (intervalEnd.isAfter(end)) {
                end = intervalEnd;
            }
        }
        if (start != null) {
            finalList.add(new LocalDate[]{start, end});
        }

        List<LocalDate[]> mergedList = new ArrayList<>();
        mergedList.add(finalList.get(0)); 
        for (int i = 1; i < finalList.size(); i++) {
            LocalDate[] currentInterval = finalList.get(i);
            LocalDate[] lastInterval = mergedList.get(mergedList.size() - 1);
            if (currentInterval[0].isEqual(lastInterval[1].plusDays(1))) {
                mergedList.set(mergedList.size() - 1, new LocalDate[]{lastInterval[0], currentInterval[1]});
            } else {
                mergedList.add(currentInterval);
            }
        }
        return mergedList;
}
}



/*
 * 
Given List of dates, which can have duplicates, for the unique dates, merge consecutive date  intervals.  
List<LocalDate[]> merge(List<LocalDate[]> dates) 
Ex: (01-Jan-23,10-Jan-23), (20-Mar-23,21-Mar-23), (01-Jan-23,10-Jan-23), (15-Mar-23,31-Mar-23), (01- Sep-23,10-Sep-23), (20-Aug-23,31-Aug-23) 
Output: (01-Jan-23,10-Jan-23), (15-Mar-23,31-Mar-23), (20-Aug-23,10-Sep-23) 
 */


 /*
  * 
  sort by increasing dates
  after, if the final date of the next one is less than or equal to the final date of the first one, remove it
  if the final date of the next one is greater than the final date of the first one, change the final date to the next one
  */