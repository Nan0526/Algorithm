package LinkedList;

import java.util.PriorityQueue;

class Hard23MergeKSortedLists {
   public ListNode mergeKLists(ListNode[] lists) {
       //two pionts:
       //1 - priorityqueue - store node
       //2 - hard copy
       
       //corner cases
       if(lists.length == 0 || lists == null) {
           return null;
       }
       
       PriorityQueue<ListNode> minHeap = new PriorityQueue<>( (a, b) -> a.val - b.val);
       for(int i = 0; i < lists.length; i++) {
           if(lists[i] != null) {
               minHeap.offer(lists[i]);
           }
       }
       
       ListNode dummy = new ListNode();
       ListNode cur = dummy;
       while(!minHeap.isEmpty()) {
           ListNode l = minHeap.poll();
           
           cur.next = new ListNode(l.val);
           cur = cur.next;
           
           if(l.next != null) {
               minHeap.offer(l.next);
           }
       }
       
       return dummy.next;
   }
   
   
 //Definition for singly-linked list.
   public class ListNode {
   	int val;
   	ListNode next;
   	ListNode() {}
   	ListNode(int val) { this.val = val; }
   	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}