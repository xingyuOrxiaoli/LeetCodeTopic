package utils;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static ListNode create(String str){
        ListNode head = null , tail = null;
        String[] split = str.substring(1, str.length() - 1).split(",");
        for(String s : split){
            if(tail == null){
                tail = new ListNode(Integer.parseInt(s));
                head = tail;
            }else{
                tail.next = new ListNode(Integer.parseInt(s));
                tail = tail.next;
            }
        }
        return head;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public void print(){
        List<Integer> list = new ArrayList<>();
        ListNode cur = this;
        while (cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        System.out.println(list);
    }
}
