    import java.util.*;

    class LRUCache {
        class Node {
            int key;
            int value;
            Node next;
            Node prev;
        }
        private int capacity;
        private final Map<Integer, Node> map = new HashMap<>();
        private Node head = new Node();
        private int size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head.prev = head;
            this.head.next = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            remove(node);
            pushFront(node);
            return node.value;
        }

        public void put(int key, int value) {
            get(key);
            if (map.containsKey(key)) {
                map.get(key).value = value;
                return;
            }
            Node node = new Node();
            node.key = key;
            node.value = value;
            pushFront(node);
            map.put(key, node);
            if (map.size() > capacity) {
                Node prev = head.prev;
                map.remove(prev.key);
                remove(prev);
            }
        }

        private void pushFront(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next = node;
            node.next.prev = node;
        }


        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public static void main(String[] args) {
            new LRUCache(2);
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

