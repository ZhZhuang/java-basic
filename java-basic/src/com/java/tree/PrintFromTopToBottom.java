package com.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 难度不大，不用细看
// 层次遍历二叉树，
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            TreeNode temp = que.poll();
            res.add(temp.val);
            if(temp.left!=null)que.offer(temp.left);
            if(temp.right!=null)que.offer(temp.right);
        }
        return res;
    }
}
