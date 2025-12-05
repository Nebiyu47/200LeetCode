package TwoPointer.Medium;
  class ListNode {
    int val;
  ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class removeNthFromEnd {
    public ListNode removeNthFromNode(ListNode head, int n){
        ListNode dummy= new ListNode(0,head);
        ListNode fast =dummy;
        ListNode sloq=dummy;
        for(int i=0;i<-n;i++){
            fast=fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            sloq=sloq.next;
        }
        sloq.next=sloq.next.next;
        return dummy.next;
    }
}
