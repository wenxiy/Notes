package com.company;

/**
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，
 * 并且每个结点没有左子结点，只有一个右子结点。
 */
public class Leetcode897 {
    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            List<Integer> vals = new ArrayList();
            inorder(root, vals);
            TreeNode ans = new TreeNode(0), cur = ans;
            for (int v: vals) {
                cur.right = new TreeNode(v);
                cur = cur.right;
            }
            return ans.right;
        }

        public void inorder(TreeNode node, List<Integer> vals) {
            if (node == null) return;
            inorder(node.left, vals);
            vals.add(node.val);
            inorder(node.right, vals);
        }
    }
}
