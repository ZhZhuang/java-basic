package com.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;

// 两种解法

// 方法一：直观
public class Tree2List {
    ArrayList<TreeNode> list = new ArrayList<>();
    public TreeNode Convert(TreeNode pRootOfTree) {
       if(pRootOfTree==null)
           return null;
       inorder(pRootOfTree);
       if(list.size()>1){
           list.get(0).right = list.get(1);
           list.get(list.size()-1).left = list.get(list.size()-2);
       }
       for (int i=1;i<list.size()-1;i++){
           list.get(i).left = list.get(i-1);
           list.get(i).right = list.get(i+1);
       }
       return list.get(0);
    }

    void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}

// 方法二：巧妙
class Solution {
    TreeNode head,pre;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        dfs(pRootOfTree);
//         head.left = pre;
//         pre.right = head;
        return head;
    }
    public void dfs(TreeNode root){
        if(root.left != null)
            dfs(root.left);
        if(pre != null)
            pre.right = root;
        else
            head = root;
        root.left = pre;
        pre = root;
        if(root.right != null)
            dfs(root.right);
    }

}
