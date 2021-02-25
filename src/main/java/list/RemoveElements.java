package list;

import adt.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode h = prev;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return h.next;
    }


}
