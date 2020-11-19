package sample;

/**
 * questions:Given the root of a binary tree, return the inorder traversal of
 * its nodes' values.
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
//做算法题一定要动脑子 不要为了看答案而做

import java.util.ArrayList;
import java.util.List;

/**
 * preorder：先序遍历
 * inorder:中序遍历
 * postorder:后续遍历
 * traversal：遍历
 * 先序遍历：遍历根节点->左子树->右子树
 * 中序遍历：左->根->右
 * 后序遍历：左->右->根
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void inorder(TreeNode root, List<Integer> helper) {
        if (root == null) return;
        else {
            inorder(root.left, helper);
            helper.add(root.val);
            inorder(root.right, helper);
            helper.add(root.val);
        }

    }

    /** 与下述基本一致。
     * 返回值设置：什么是平衡二叉树：如果一个树的左右子树的高度相差小于1，那么就说明此树为平衡二叉树。
     * 那么我们既然要设置平衡二叉树，就要考虑一个问题，就是当所有的节点都平衡了，才叫平衡。
     * 所以我们返回的结果不仅仅有当前节点，而且是需要有左子树节点和右子树节点的。所以返回值是这些节点的相与。
     *
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null){//必须进行判断。
            return true;
        }
            return Math.abs(getheight(root.left) - getheight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 二叉树的高度就是左右子树最大深度+1，利用这一点来进行递归
     * 第一步：找到返回条件：返回最大深度+1
     * 第二步：定义返回条件：什么是深度：树的深度定义是递归定义：自己子树的深度一直遍历，当
     * 到达最后一个的时候结束遍历返回第一个深度，递推再推上去。
     * 第三步：进行特殊条件考虑：如果一个树是空的，那么这个树的深度就为0
     */
    public int getheight(TreeNode root) {
        if (root == null) return 0;
        int mheightleft = getheight(root.left);
        int mheightright = getheight(root.right);
        int heightmax = Math.max(mheightleft, mheightright);
        return heightmax + 1;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
