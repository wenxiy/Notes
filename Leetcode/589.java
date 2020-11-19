package com.company;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

/**
 * 先序遍历：根->左->右
 */
public class Main {
    List<Integer> value = new ArrayList<>();
    public void main(String[] args) {
        // write your code here
        Node root = new Node(1);
        dfs(root);
    }

    public  void dfs(Node root){
        if (root == null ) return ;
        value.add(root.val);
        for (Node child : root.children){
            dfs(child);
        }
    }
}
