
import java.util.*;

public class PartitionSum{

    public static void main(String[]args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(8,9,10);
        int partition = 2;

        List<Integer> result = sumAlternate(list1, list2, partition);
        System.out.println(result);
    }
    public static List<Integer> sumAlternate(List<Integer> list1, List<Integer> list2, int partition) {
       List<Integer> result = new ArrayList<>();
       
       List<Integer> sums1 = sumPartitions(list1, partition);
       List<Integer> sums2 = sumPartitions(list2, partition);

        int maxSize = Math.max(sums1.size(), sums2.size());
        for (int i = 0; i < maxSize; i++){
            if (i<sums1.size()) {
                result.add(sums1.get(i));
            }
            if (i < sums2.size()) {
                result.add(sums2.get(i));
            }
        }

        return result;

    }

    private static List<Integer> sumPartitions(List<Integer> list, int partition) {
        List<Integer> sums = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i += partition) {
            int sum = 0;
            for (int j = i; j < Math.min(i + partition, size); j++) {
                sum += list.get(j);
            }
            sums.add(sum);
        }
        return sums;
    }

}
