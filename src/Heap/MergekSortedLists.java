package Heap;

import java.util.PriorityQueue;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
   ListNode(int val ){this.val=val;}
    ListNode(int val , ListNode next){
        this.val=val;
        this.next=next;
    }

}
public class MergekSortedLists {
    public static void main(String[] args) {

    }
    public static ListNode MergekSortedLists(ListNode[] lists){
        if(lists==null || lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode node : lists){
            if(node!=null){
                pq.offer(node);
            }
        }

        ListNode dummy= new ListNode(0);
        ListNode current= dummy;
        while(!pq.isEmpty()){
            ListNode minNode= pq.poll();
            current.next=minNode;
            current=current.next;
            if(minNode.next!=null){
                pq.offer(minNode.next);
            }
        }
        return dummy.next;

    }
}
