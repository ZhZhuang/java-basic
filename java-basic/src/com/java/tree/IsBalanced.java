package com.java.tree;


// 难度：简单
// 判断一棵树是不是平衡二叉树
// 逻辑：左右高度只差小于等于1，并且左右子树都是平衡二叉树。
public class IsBalanced {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + (leftHeight > rightHeight ? leftHeight :rightHeight);
    }


    // 逻辑错误
    /*public boolean IsBalanced_Solution (TreeNode pRoot) {
        // write code here
        if(pRoot == null)
            return true;
        return Math.abs(help(pRoot.left) - help(pRoot.right)) <= 1;
    }

    int help(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(help(root.left), help(root.right)) + 1;
    }*/
}
