package com.company;

import java.util.HashMap;
//利用HashMap实现的链表的深拷贝。如果涉及链表的深拷贝，都可以用HashMap来实现这个算法，复杂度都是O（N）
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public Node(int val,Node next,Node random){
        this.val=val;
        this.next = next;
        this.random = random;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        //HashMap test
        HashMap<Integer,String> Node = new HashMap<Integer,String>();
        Node.put(1,"123");
        Node.put(2,"234");
        Node.put(3,"345");
        System.out.println("hello world");
        System.out.println(Node.get(2));//如果返回null就无法判断Key是否存在，如果存在且Value是null，则不能判断key是否存在
        System.out.println(Node.containsKey(1));//containKey、containValue返回值都是布尔类型。
    }
}
//以下是题解，来自官方题解
class Solution {
    // Visited dictionary to hold old node reference as "key" and new node reference as the "value"
    HashMap<Node, Node> visited = new HashMap<Node, Node>();

    public Node getClonedNode(Node node) {
        // If the node exists then
        if (node != null) {
            // Check if the node is in the visited dictionary
            if (this.visited.containsKey(node)) {
                // If its in the visited dictionary then return the new node reference from the dictionary
                return this.visited.get(node);
            } else {
                // Otherwise create a new node, add to the dictionary and return it
                this.visited.put(node, new Node(node.val, null, null));
                return this.visited.get(node);
            }
        }
        return null;
    }

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node oldNode = head;

        // Creating the new head node.
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        // Iterate on the linked list until all nodes are cloned.
        while (oldNode != null) {
            // Get the clones of the nodes referenced by random and next pointers.
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            // Move one step ahead in the linked list.
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }
}
