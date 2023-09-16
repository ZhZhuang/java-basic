package com.java.tree;

public class HasPathSum {
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if(root==null)return false;

        return helper(root,sum);
    }
    public boolean helper (TreeNode root, int sum) {
//        if (root==null){
//            if( sum == 0)
//                return true;
//            else
//                return false;
//        }
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && root.val == sum)
            return true;
        sum-=root.val;
        boolean left = helper(root.left, sum);
        boolean right = helper(root.right, sum);
        return  left || right;
    }
}
