package medium.A146;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LRU缓存 {
    public static void main(String[] args) {

    }

}
class LRUCache {
    private Integer capacity ;
    private HashMap<Integer, Integer> map;
    private HashMap<Integer, Integer> index;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.index = new HashMap<>();
    }

    public int get(int key) {
        int value = map.getOrDefault(key, -1);
        if (value == -1) {
            return -1;
        }
        return value;
    }

    public void put(int key, int value) {
        int preValue = map.getOrDefault(key, -1);
        if (preValue == -1) {

        }
        map.put(key, value);
    }
}