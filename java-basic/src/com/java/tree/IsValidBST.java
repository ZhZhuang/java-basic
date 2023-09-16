package com.java.tree;

import java.util.LinkedList;

public class IsValidBST {
    LinkedList<Integer> list = new LinkedList<>();
    public boolean isValidBST_1 (TreeNode root) {
        // write code here
        mid(root);
        int pre = Integer.MIN_VALUE;
        for(int i : list){
            if(i<pre) return false;
            pre = i;
        }
        return true;
    }

    void mid(TreeNode root){
        if(root==null)return;
        mid(root.left);
        list.add(root.val);
        mid(root.right);
    }

    //中序遍历二叉搜索树，遍历的结果一定是有序的，如果不明白中序遍历的可以看下前面的373，数据结构-6,树。中序遍历时，
    //判断当前节点是否大于中序遍历的前一个节点，也就是判断是否有序，如果不大于直接返回 false。
    int pre = Integer.MIN_VALUE;
    public boolean isValidBST (TreeNode root) {
        if (root == null)  return true;

        if(!isValidBST(root.left)) return false;
        //中序位置
        if(root.val < pre ) return false;
        //更新最值
        pre = root.val;
        if(!isValidBST(root.right)) return false;
        return true;

    }
}
