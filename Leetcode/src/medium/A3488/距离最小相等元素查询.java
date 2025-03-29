package medium.A3488;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 距离最小相等元素查询 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1,4,1,3,2};
        int[] queries  = new int[]{0,3,5};
        new 距离最小相等元素查询().solveQueries(nums,queries);
    }
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> res =  new ArrayList<>();
        int nlength = nums.length;
        int qlength = queries.length;

        Map<Integer,List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nlength; i++) {
            int num = nums[i];
            List<Integer> list = map.getOrDefault(num, new ArrayList<>());
            list.add(i);
            map.put(num, list);
            indexMap.put(i, list.size() - 1);
        }

        for(int i = 0 ;i < qlength ; i++){
            int index = queries[i];
            List<Integer> list = map.get(nums[index]);
            int size = list.size();
            if(size == 1) res.add(-1);
            else {
                int elm = indexMap.get(index);
                if(elm == (size -1)){
                    int next = list.get(0);
                    int pre = list.get(elm -1);
                    res.add(Math.min(nlength - index + next,index - pre));
                }else{
                    int next = list.get(elm + 1);
                    if(elm == 0){
                        int pre = list.get(size -1);
                        res.add(Math.min(nlength - pre + index,next - index));
                    }else{
                        int pre = list.get(elm -1);
                        res.add(Math.min(index - pre,next -index));
                    }
                }
            }
        }

        return res;
    }
}
