package LinkedList;

import java.util.List;


/*
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
 */

public class Mid19RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = (ListNode) dummy; // 一定要弄清这个关系 - 确保最后slow落脚在n的前一个 - 
        
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        
        return dummy.next;
    }
	
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}







/*
bad
//corner case
        
        int size = 1;
        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
            size++;
        }
        int index = size - n + 1;
        
        cur = head;
        while(index-- > 1) {
            cur = cur.next;
        }
        ListNode change = cur.next;
        ListNode next = cur.next.next;
        change.next = null;
        cur.next = next;
        
        return head;
*/