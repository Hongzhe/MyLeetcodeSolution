package list;


import adt.Helper;
import adt.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 *
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 *
 */
public class PalindromeLinkedList {

    //reverse the first half
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            ListNode next = slow.next;
            if (prev != null) {
                slow.next = prev;
            }
            prev = slow;
            fast = fast.next.next;
            slow = next;
        }
        if (fast != null) slow = slow.next; //odd number of nodes.
        while (slow != null) {
            if (slow.val != prev.val) return false;
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.fromArray(Helper.strToArray("[1,2,3,2,1]"));
        PalindromeLinkedList target = new PalindromeLinkedList();
        System.out.println(target.isPalindrome(list));
    }
}
