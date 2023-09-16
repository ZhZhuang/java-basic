package com.java.tree;


// 二叉搜索树的最近公共祖先
// 有难度！
public class LowestCommonAncestor {

    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        if(root==null) return -1;
        if(root.val==p || root.val==q) return root.val;
        int left=lowestCommonAncestor(root.left,p,q);
        int right=lowestCommonAncestor(root.right,p,q);
        if(left==-1) return right;
        else if(right==-1) return left;
        else return root.val;
    }
}
