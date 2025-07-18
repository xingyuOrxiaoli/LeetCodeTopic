import utils.ArrayUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

class Solution {

    char ch ;
    String str ;
    Solution(){
        System.out.println(str == null);
        System.out.println(ch == ' ');
        System.out.println(ch);
        Integer a = -128;
        Integer b = -128;
        System.out.println(a == b);
    }
    public static void main(String[] args) throws IOException {
        new Solution();
        List<Integer> haveTime , notHaveTime;
        HashMap<Integer , List<Integer>> haveTimeMap = new HashMap<>() , notHaveTimeMap = new HashMap<>() ;
        String path = "D:\\note\\ustb_xiaoli\\AQXJ\\first\\HDF\\data\\GEOQK";
        File file = new File(path);
        File[] listFiles = file.listFiles();
        for (File listFile : listFiles) {
            String fileName = listFile.getName();
            String dateStr = fileName.split("_")[4];
            haveTime = haveTimeMap.getOrDefault(Integer.parseInt(dateStr) , new ArrayList<>());
            if(!haveTimeMap.containsKey(Integer.parseInt(dateStr))) haveTimeMap.put(Integer.parseInt(dateStr) , haveTime);
            String timeStr = fileName.split("_")[5];
            Integer curTime = Integer.parseInt(timeStr);
            haveTime.add(curTime);
        }

        for (Integer key_date : haveTimeMap.keySet()) {
            haveTime = haveTimeMap.get(key_date);
            notHaveTime = notHaveTimeMap.getOrDefault(key_date, new ArrayList<>());
            if(!notHaveTimeMap.containsKey(key_date)) haveTimeMap.put(key_date , haveTime);

            int min = 0 , hour = 0, left = 0;
            while(hour != 23 || min != 55){
                if(left < haveTime.size()&& haveTime.get(left).equals(hour * 100 + min)){
                    left ++;
                }else notHaveTime.add(hour * 100 + min);
                min += 5;
                hour += min / 60;
                min %= 60;
            }
            System.out.println("=================== 2025年"+key_date+"不包含的时间 ===================");
            System.out.println(notHaveTime.size());
            System.out.println(notHaveTime);
//        notHaveTime.forEach(System.out::println);
            System.out.println("=================== 2025年"+key_date+"包含的时间 ===================");
            System.out.println(haveTime.size());
            System.out.println(haveTime);
//        haveTime.forEach(System.out::println);
        }

    }

}