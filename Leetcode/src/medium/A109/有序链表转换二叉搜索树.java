package medium.A109;

import utils.ListNode;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 有序链表转换二叉搜索树 {

    public static void main(String[] args) {

    }

    List<Integer> list = new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0 , right = list.size() - 1;
        TreeNode root = buildTreeNode(left , right);
        return root;
    }

    private TreeNode buildTreeNode(int left, int right) {
        if(left > right) return null;
        int mid = left + ((right - left) >> 1);
        TreeNode res = new TreeNode(list.get(mid));
        res.left = buildTreeNode(left, mid - 1);
        res.right = buildTreeNode(mid + 1, right);
        return res;
    }
}
