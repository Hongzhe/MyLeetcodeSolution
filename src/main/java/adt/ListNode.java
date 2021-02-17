package adt;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode fromArray(int[] nums) {
        ListNode node = new ListNode(nums[0]);
        ListNode tmp = node;
        for (int i = 1; i < nums.length; i++) {
            ListNode next = new ListNode(nums[i]);
            tmp.next = next;
            tmp = next;
        }
        return node;
    }

    public static ListNode buildCycle(int[] nums, int idx) {
        ListNode node = new ListNode(nums[0]);
        ListNode tmp = node;
        ListNode begin = null;
        for (int i = 1; i < nums.length; i++) {
            ListNode next = new ListNode(nums[i]);
            tmp.next = next;
            tmp = next;
            if (i == idx) {
                begin = next;
            } else if (i == nums.length - 1) {
                next.next = begin;
            }
        }
        return node;
    }

    public static void printList(ListNode listNode) {
        if (listNode == null) {
            System.out.println();
            return;
        };
        ListNode tmp = listNode;
        System.out.print(tmp.val + " -> ");
        printList(listNode.next);
    }
}
