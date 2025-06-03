package medium.A146;

import java.util.*;

public class LRU缓存 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5, 5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));

    }

}
class LRUCache {
    private int capacity ;
    private int size     ;
    private HashMap<Integer, Integer> map;
    private Queue<Integer> queue;
    private HashMap<Integer,Integer> nodeSum;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
        this.nodeSum = new HashMap<>();
    }

    public int get(int key) {
        int value = map.getOrDefault(key, -1);
        if(value == -1) return value;

        Integer peek = queue.peek();
        if(!queue.isEmpty()) {
            while (peek == key || !map.containsKey(peek)) {
                queue.poll();
                nodeSum.put(peek, nodeSum.get(peek) - 1);
                if(queue.isEmpty()) break;
                peek = queue.peek();
            }
        }
        queue.offer(key);
        nodeSum.put(key, nodeSum.getOrDefault(key,0) + 1);
        return value;
    }

    public void put(int key, int value) {
        int preValue = map.getOrDefault(key, -1);
        if (preValue == -1) {
            this.size ++;
            if(this.size > this.capacity) {
                int node = queue.poll();
                nodeSum.put(node, nodeSum.get(node) - 1);
                while(!map.containsKey(node) ||  nodeSum.get(node) > 0){
                    node = queue.poll();
                    nodeSum.put(node, nodeSum.get(node) - 1);
                }
                map.remove(node);
                this.size --;
            }
        }
        if(!queue.isEmpty()) {
            Integer peek = queue.peek();
            while (peek == key) {
                queue.poll();
                nodeSum.put(peek, nodeSum.get(peek) - 1);
                if(queue.isEmpty()) break;
                peek = queue.peek();
            }
        }
        queue.offer(key);
        nodeSum.put(key, nodeSum.getOrDefault(key,0) + 1);
        map.put(key, value);
    }
}

class Solution{
    class LRUCache {
        //内部类要设为private，定义一个doubly ListNode，Node是链表的节点，
        //Node是我们自定义的(有key和value两个)，而不是通常的ListNode(只有一个value)
        private class Node {
            //因为题目中有key和value两个值，所以Node中也定义两个
            private int key;
            private int value;
            //doubly LinkedList有前后两个指针
            private Node next;
            private Node previous;
            //构造方法
            public Node(int key, int value) {
                this.key = key;
                this.value = value;
                next = null;
                previous = null;
            }
        }

        //LRUCache类的属性
        //capacity是LRU的存储容量，即是LinkedList的最多Node个数
        private int capacity;

        //key存Node的key值, value存key对应的这个Node的引用(内存地址)
        private HashMap<Integer, Node> map = new HashMap();

        //将doubly LinkedList夹在head和tail之间，head和tail都是dummy node，因为有moveToTail这个方法，即将某个节点变成most recently used Node，
        //所以有tail能比较方便将Node插入到doubly LinkedList的末尾，这两个dummy node的值(key, value)不重要.
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);

        //LRUCache的构造方法
        public LRUCache(int capacity) {
            this.capacity = capacity;
            //首尾相连
            head.next = tail;
            tail.previous = head;

        }

        //如果存在则返回key对应的value，不存在则返回-1
        public int get(int key) {
            //存在
            if(map.containsKey(key)) {
                //获取key对应的Node的地址
                Node current = map.get(key);
                //因为通过get访问了当前这个Node，所以此Node变成most recently used Node，所以要把此Node移动到doubly LinkedList的末尾.
                //1.将此Node从doubly LinkedList中原先的位置上删除，会影响它前面的点的next指向及它后面的点的previous指向，所以要修改这两个节点的指针.
                current.previous.next = current.next;
                current.next.previous = current.previous;
                //2.将Node插入到doubly LinkedList的末尾
                moveToTail(current);
                //上面moveToTail的操作并没有真正改变此Node在内存中的位置，只是改变了此Node中next和previous中存的值，
                //所以current还是指向这个Node在内存中的位置，所以current.val还是这个Node的value值.
                return current.value;
                //节点不存在
            } else {
                return -1;
            }
        }

        //已存在则update，不存在则要判断cache是否已满
        public void put(int key, int value) {
            //如果key对应的节点存在，则直接找到它并修改它的value，修改完后相当于访问了这个节点，它就变成了most recently used node，要移动到最右边.
            //此处if条件可以使用get(key) != -1这个LRUCache的方法，get方法中包含了删除节点及移动到末尾的操作
            if(map.containsKey(key)) {
                //获取key对应的Node的地址
                Node current = map.get(key);
                //update Node中的value
                current.value = value;
                //1.删除Node，会影响它前面的点的next指向及它后面的点的previous指向
                current.previous.next = current.next;
                current.next.previous = current.previous;
                //2.访问完后移动到最右边
                moveToTail(current);
                return;
            }

            //如果不存在，则先判断LRU是否已满
            //如果满了，则要删除least recently used的记录，即要删除map中对应的记录并把doubly LinkedList中最左边的节点删掉空出位置来，
            //再把新节点添加到doubly LinkedList的末尾和map中.
            if(map.size() == capacity) {
                //1.删除最左节点在map中对应的记录，要先删除记录，如果先删节点，则此时head.next已经指向原链表中的左边第2个节点了，不再是原先最左边的节点了.
                map.remove(head.next.key);
                //2.删除doubly LinkedList中最左边的节点
                head.next = head.next.next;
                //经过上一行代码，此时head.next已经指向原先的左2节点了，所以这里就不用head.next.next了
                head.next.previous = head;
            }
            //1.创建节点
            Node current = new Node(key, value);
            //2.添加到map中
            map.put(key, current);
            //3.新创建的节点成为most recently used node，移动到末尾
            moveToTail(current);
        }

        //将current节点插入到doubly LinkedList的末尾，current节点本身在内存中的位置自从创建后就不会再变，改的都是next和previous的值。
        //即插入到doubly LinkedList真正的末尾节点和tail这个dummy节点之间。
        private void moveToTail(Node current) {
            tail.previous.next = current;
            current.previous = tail.previous;
            current.next = tail;
            tail.previous = current;
        }
    }
}