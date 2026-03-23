package medium.A501;

import utils.TreeNode;

import java.util.Arrays;

public class 二叉搜索树中的众数 {
    public static void main(String[] args) {

        A501Solution solution = new A501SolutionMethodV1();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
//        root.right.right = new TreeNode(2);
        int[] mode = solution.findMode(root);
        System.out.println(Arrays.toString(mode));
    }}