package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 遍历size（queue提供的root进去的size）其实就是遍历每一层节点，因为queue进入的是root根，但是如果我们想要遍历他的孩子只需要
 * 去删除第一个根节点，然后就到了第二个根节点，就可以left right来遍历
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    public List<List<Integer>> soluation(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();//每一层的节点值
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                subList.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.add(treeNode.right);
                }
            }
           res.add(subList);
        }
        return res;
    }
}
