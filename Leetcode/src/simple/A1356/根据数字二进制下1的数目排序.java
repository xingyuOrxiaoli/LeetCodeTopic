package simple.A1356;

import java.util.*;

public class 根据数字二进制下1的数目排序 {

    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int item : arr) {
            map.put(item, getItemBitNums(item));
            list.add(item);
        }

        list.sort((o1, o2) -> {
            Integer a = map.get(o1);
            Integer b = map.get(o2);
            if (a.equals(b)) {
                return o1.compareTo(o2);
            }
            return a.compareTo(b);
        });
        return list.stream().mapToInt(i -> i).toArray();
    }

    private int getItemBitNums(int num) {
        int res = 0;
        while (num != 0) {
            if (num % 2 != 0) {
                res++;
            }
            num >>= 1;
        }
        return res;
    }
}
