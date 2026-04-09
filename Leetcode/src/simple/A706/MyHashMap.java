package simple.A706;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap {

    private final int MAX_OP = 10000;

    private List<Integer[]>[] map;

    public MyHashMap() {
        map = new LinkedList[MAX_OP];
    }

    public void put(int key, int value) {
        int index = key % MAX_OP;
        if (map[index] == null) {
            LinkedList<Integer[]> list = new LinkedList<>();
            list.add(new Integer[]{key,value});
            map[index] = list;
        } else {
            List<Integer[]> list = map[index];
            Iterator<Integer[]> iterator = list.iterator();
            while (iterator.hasNext()) {
                Integer[] next = iterator.next();
                if (next[0] == key) {
                    iterator.remove();
                    break;
                }
            }
            list.add(new Integer[]{key,value});
        }
    }

    public int get(int key) {
        int index = key % MAX_OP;
        List<Integer[]> list = map[index];
        if (list != null) {
            for (Integer[] entry : list) {
                if(entry[0] == key) {
                    return entry[1];
                }
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % MAX_OP;
        List<Integer[]> list = map[index];
        if (list != null) {
            Iterator<Integer[]> iterator = list.iterator();
            while (iterator.hasNext()) {
                Integer[] next = iterator.next();
                if(next[0] == key) {
                    iterator.remove();
                    break;
                }
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */