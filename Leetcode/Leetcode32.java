package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：二叉树的中序遍历
 * 思路：左->根->右 递归实现很简单，主要是迭代实现。我们先递归来实现这个程序
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int x) {
        x = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<Integer>();
        }
        return res;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello wrold");
        /**
         * 第一种是递归法，接下来要使用迭代法，主要是堆栈的问题
         */
    }
}
