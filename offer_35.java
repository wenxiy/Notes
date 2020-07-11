import java.util.HashMap;

public class solution {
    HashMap<Node,Node> visited= new HashMap<Node,Node>();
    public Node getclone(Node head){
        if(head!=null){
            if(this.visited.containsKey(head)){
                return this.visited.get(head);
            }
            else{
                this.visited.put(head,new Node(head.val,null,null));
                return this.visited.get(head);
            }
        }
        return null;
    }
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node oldnode=head;
        Node newnode=new Node(oldnode.val);
        this.visited.put(oldnode,newnode);
        while(oldnode!=null){
            newnode.random=this.getclone(oldnode.random);
            newnode.next=this.getclone(oldnode.next);
            oldnode=oldnode.next;
            newnode=newnode.next;
        }
        return this.visited.get(head);
    }
}
