package adt;

import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        this.val = x;
    }

    //数组元素需要中序排列
    public static TreeNode fromArray(Integer[] nums) {
        if (nums.length == 0) return null;
        return fromArray(nums, 0);
    }

    //{2,null,3,null,4,null,5,null,6}
    private static TreeNode fromArray(Integer[] nums, int start) {
        if (nums[start] == null) return null;
        TreeNode root =  new TreeNode(nums[start]);
        int l = 2*start + 1, r = 2*start + 2;
        if (l <= nums.length - 1) {
            root.left = fromArray(nums, l);
        }
        if (r <= nums.length - 1) {
            root.right = fromArray(nums, r);
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }

    public static void printBFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            sb.append(node.val).append(" ");
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        System.out.println(sb.toString());
    }
}
