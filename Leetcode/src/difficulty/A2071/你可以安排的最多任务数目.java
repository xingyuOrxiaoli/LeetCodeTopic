package difficulty.A2071;

import java.util.Arrays;
import java.util.TreeMap;

public class 你可以安排的最多任务数目 {
    public static void main(String[] args) {
        int[] tasks = {5,9,8,5,9};
        int[] workers = {1,6,4,2,6};

        int i = new 你可以安排的最多任务数目().maxTaskAssign1(tasks,workers,1,5);
        System.out.println(i);
    }

    // 方法 1
    public int maxTaskAssign1(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 0, right = Math.min(tasks.length, workers.length) ,  res = 0;
        while(left <= right) {
            int mid = (right + left) >> 1;
            if(check(tasks,workers,pills,strength,mid)) {
                left = mid + 1;
                res = mid;
            }
            else right = mid - 1;
        }
        return res;
    }

    private boolean check(int[] tasks, int[] workers, int pills, int strength, int mid) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // 检验 前mid个最大的工作者 是否可以，如果可以说明mid是小于的，因此left向右移动
        for(int i = workers.length - mid ; i < workers.length ; i++) map.put(workers[i], map.getOrDefault(workers[i], 0) + 1);
        // 开始检验每个元素  ，先从最大的检验
        for (int i = mid - 1 ; i >= 0 ; i--) {
            Integer temp = map.lastKey(); // 工作者最大的元素
            if(temp >= tasks[i]){
                map.put(temp,map.get(temp) - 1); // 去掉一个
                if(map.get(temp) == 0) map.remove(temp);
            }else{
                // 没药了而且还小于
                if(pills == 0 ) return false;
                if((temp = map.ceilingKey(tasks[i] - strength) ) == null) return false;

                map.put(temp,map.get(temp) - 1); // 去掉一个
                if(map.get(temp) == 0) map.remove(temp);
                pills --;
            }
        }
        return true;
    }
    private boolean check2(int[] tasks, int[] workers, int pills, int strength, int mid) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = workers.length - mid ; i < workers.length ; i++) map.put(workers[i] , map.getOrDefault(workers[i],0) + 1);
        for(int i = mid - 1 ; i > -1 ; i --){
            Integer temp = map.lastKey();
            if(temp < tasks[i]){
                if(pills == 0) return false;
                temp = map.ceilingKey(tasks[i] - strength);
                if(temp == null) return false;
                pills --;
            }
            map.put(temp,map.get(temp) - 1);
            if(map.get(temp) == 0) map.remove(temp);
        }
        return true;
    }


    // 方法 2
//    public int maxTaskAssign2(int[] tasks, int[] workers, int pills, int strength) {
//    }
}
