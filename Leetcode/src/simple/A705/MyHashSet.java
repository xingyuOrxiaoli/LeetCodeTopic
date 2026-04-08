package simple.A705;

import java.util.Arrays;

class MyHashSet {

    private final Integer MAX_OP = 1000001;
    private final Integer[] hash = new Integer[MAX_OP];

    public MyHashSet() {
        Arrays.fill(hash,-1);
    }

    public void add(int key) {
        int index = key % MAX_OP;
        while (hash[index] != -1 && hash[index] != key) {
            index = (index + 1) % MAX_OP;
        }
        if (hash[index] == -1) {
            hash[index] = key;
        }
    }

    public void remove(int key) {
        int index = key % MAX_OP;
        while (hash[index] != -1 && hash[index] != key) {
            index = (index + 1) % MAX_OP;
        }
        if(hash[index] == key) {
            hash[index] = -1;
        }
    }

    public boolean contains(int key) {
        int index = key % MAX_OP;
        while (hash[index] != -1 && hash[index] != key) {
            index = (index + 1) % MAX_OP;
        }
        return hash[index] == key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */