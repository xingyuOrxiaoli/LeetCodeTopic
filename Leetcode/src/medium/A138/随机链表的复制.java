package medium.A138;

import utils.Node;

import java.util.*;

public class 随机链表的复制 {
    public static void main(String[] args) {
        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head.random = null;
        node1.random = head;
        node2.random = node4;
        node3.random = node2;
        node4.random = head;

        Node node = new 随机链表的复制().copyRandomList(head);

    }

    // 方法1
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Integer, List<Node>> dict1 = new HashMap<>(),dict2 = new HashMap<>();
        Node res = new Node(head.val);
        dict1.put(head.val , new ArrayList<>());
        dict1.get(head.val).add(head);

        dict2.put(res.val , new ArrayList<>());
        dict2.get(res.val).add(res);

        Node temp1 = head.next , temp2 = res;
        while (temp1 != null) {
            temp2.next = new Node(temp1.val);
            temp2 = temp2.next;

            List<Node> list = dict1.getOrDefault(temp1.val, new ArrayList<>());
            list.add(temp1);
            if(list.size() ==1) dict1.put(temp1.val , list);

            list = dict2.getOrDefault(temp2.val, new ArrayList<>());
            list.add(temp2);
            if(list.size() ==1) dict2.put(temp2.val , list);

            temp1 = temp1.next;
        }

        temp2 = res;
        while(head != null){
            Node random = head.random;
            if(random == null){
                temp2.random = random;
            }else{
                List<Node> list = dict1.get(random.val);
                int i = 0 ;
                System.out.println(list.get(i) == random);
                while(list.get(i) != random) i ++;
                temp2.random = dict2.get(random.val).get(i) ;
            }

            temp2 = temp2.next;
            head = head.next;
        }

        return res;
    }

    // 方法2 因Node没有重写hash函数和toString函数 因此Node对象对于属性完全相同的值域是没问题的
    public Node copyRandomList2(Node head) {
        if(head == null) return null;
        Map<Node,Node> dict = new HashMap<>();
        Node res = new Node(head.val);
        dict.put(head , res);
        // 先顺序一趟
        Node temp1 = head.next , temp2 = res;
        while (temp1 != null) {
            temp2.next = new Node(temp1.val);
            temp2 = temp2.next;
            dict.put(temp1,temp2);
            temp1 = temp1.next;
        }
        temp2 = res;
        while(head != null){
            Node random = head.random;
            if(random == null){
                temp2.random = random;
            }else{
                temp2.random = dict.get(random);
            }
            temp2 = temp2.next;
            head = head.next;
        }

        return res;
    }
}
