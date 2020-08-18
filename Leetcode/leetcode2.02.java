package com.company;

import java.util.HashMap;

class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    public int kthToLast(ListNode head, int k) {
        ListNode pA=head;
        for(int i=0;i<k;i++){
            pA=pA.next;
        }
        while(pA!=null){
            pA=pA.next;
            head=head.next;
        }
        return head.val;
    }
}
