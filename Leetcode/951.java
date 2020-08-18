package com.company;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Main {
    class Solution {
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) return true;
            if (root1 == null || root2 == null) return false; //定义返回结果值
            if (root1.left == null && root2.left == null)
                return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
            if (root1.left == null || root2.left == null)
                return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
            if (root1.left != null && root2.right != null && root1.left.val != root2.left.val)
                return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
            return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        }
    }

    public void main(String[] args) {
        // write your code here
    }
}
