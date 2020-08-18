package com.company;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Main {
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(0);
        ListNode lage=new ListNode(0);
        ListNode l1=small;
        ListNode r1=lage;
        lage.next=null;
        small.next=null;
        while(head!=null){
            if(head.val>=x){
                lage.next=head;
                lage=lage.next;
            }
            if(head.val<x){
                small.next=head;
                small=small.next;
            }
            head=head.next;
        }
        lage.next=null;
        small.next=r1.next;
        return l1.next;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(0);
    }
}
