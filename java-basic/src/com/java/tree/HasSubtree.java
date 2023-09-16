package com.java.tree;


import java.util.LinkedList;

// 有难度
// 树的子结构
// 如何子结构是难点
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //BFS
        if(root1 == null || root2 == null) return false;

        LinkedList<TreeNode> q = new LinkedList<>();

        q.add(root1);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(issame(cur, root2)) return true;

            if(cur.left != null) q.add(cur.left);
            if(cur.right != null) q.add(cur.right);
        }

        return false;

    }

    //判断两棵树是否相等
    public boolean issame(TreeNode root1, TreeNode root2){
        if(root2 == null) return true;
        if(root1 == null) return false;

        return (root1.val == root2.val) && issame(root1.left, root2.left) && issame(root1.right, root2.right);
    }

//    public boolean HasSubtree_2(TreeNode root1,TreeNode root2) {
//        if(root2==null || root1==null)
//            return false;
//        if(root1.val== root2.val && issame(root1.left,root2.left) && issame(root1.right,root2.right))
//            return true;
//        else
//            return HasSubtree_2(root1.left, root2) || HasSubtree_2(root1.right, root2);
//    }



}
