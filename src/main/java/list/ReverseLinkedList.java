package list;

import adt.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode next = null, prev = null;
        ListNode tmp = head;
        while (tmp != null) {
            next = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = next;
        }
        return prev;
    }
}
