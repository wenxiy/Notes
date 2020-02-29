/*给出两个非空的链表用来表示两个非负的整数。
其中,它们各自的位数是按照逆序的方式存储的,
并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来,则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/add-two-numbers
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){val=x;}
}
class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode(0);//最后返回的单链表
        ListNode l3=pre;
        int carry=0;
        while(l1!=null||l2!=null) {
            int x=(l1==null)?0:l1.val;
            int y=(l2==null)?0:l2.val;
            int sum=x+y+carry;
            carry=sum/10;
            sum=sum%10;
            l3.next=new ListNode(sum);
            l3=l3.next;
            if (l1!=null)
                l1=l1.next;
            if (l2!=null)
                l2=l2.next;
        }
        if(carry==1)
        {
            l3.next=new ListNode(1);
        }
        return pre.next;
    }

}
