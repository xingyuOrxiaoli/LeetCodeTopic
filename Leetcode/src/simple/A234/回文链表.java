package simple.A234;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0 , right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) return false;
            left ++;
            right --;
        }
        return true;
    }
}
