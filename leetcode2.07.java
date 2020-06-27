package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,ListNode> list=new HashMap<>();
        if(headA==null||headB==null){
            return null;
        }
        ListNode pA=headA;
        while(pA!=null){
            list.put(pA,headA);
            pA=pA.next;
        }
        ListNode pB=headB;
        while(pB!=null){
            if(list.containsKey(pB)) {
                return pB;
            }
            pB=pB.next;
        }
        return null;
    }
}