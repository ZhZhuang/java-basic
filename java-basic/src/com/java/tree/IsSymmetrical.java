package com.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 不太好想方法
// 对称的二叉树，沿着中轴对称
// 两种方法：层次，递归
// 思想被限制了，层次遍历应给是可以想到的
public class IsSymmetrical {

    //原：层序遍历,右是否等于左,根据当前节点用下面的左右节点做判断
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null)
            return true;
//        ArrayList<TreeNode> que = new ArrayList<>();
//        ArrayList<TreeNode> que2 = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        LinkedList<TreeNode> que2 = new LinkedList<>();
        que.offer(pRoot);
        while (!que.isEmpty() || !que2.isEmpty()){
            if(!que.isEmpty()){
                for (int i = 0,j = que.size()-1; i < j; i++,j--) {
                    if(que.get(i).val != que.get(j).val)
                        return false;
                }
                while (!que.isEmpty()){
                    que2.offer(que.poll());
                }
            }
            if(!que2.isEmpty()){
                for (int i = 0,j = que2.size()-1; i < j; i++,j--) {
                    if(que2.get(i).val != que2.get(j).val)
                        return false;
                }
                while (!que2.isEmpty()){
                    que.offer(que2.poll());
                }
            }
        }
        return true;
    }



    boolean isSymmetrical_2(TreeNode pRoot) {
        //递归
        return recursion(pRoot,pRoot);
    }

    boolean recursion(TreeNode node1, TreeNode node2){
        //两个都为空
        if(node1 == null && node2 == null){
            return true;
        }
        //只有一个为空或者节点值不同，不队称
        if(node1 == null || node2 == null || node1.val != node2.val){
            return false;
        }
        //每层对应的节点进入递归比较
        return recursion(node1.left,node2.right) && recursion(node1.right, node2.left);
    }
}
