package Tree;
 class ListNode {
     int val;
    ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class sortedLinkedListToBST {

    public static void main(String[] args) {

    }
    public static TreeNode sortedListToBST(ListNode head){

        if(head==null)return null;
        if (head.next==null)return new TreeNode(head.val);

        ListNode findMid= FindMid(head);
        TreeNode root = new TreeNode(findMid.val);
        if(head==findMid){
            root.left=null;
        }else{
            root.left=sortedListToBST(head);
        }
        root.right=sortedListToBST(head.next);
return root;
    }
    public static ListNode FindMid(ListNode head){
         ListNode prev=null;
         ListNode slow= head;
         ListNode fast= head;
         while (fast!=null|| fast.next!=null){
             prev=slow;
             slow=slow.next;
             fast=fast.next.next;
         }
         if(prev!=null)prev.next=null;
         return slow;
    }
}
