package com.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 之字型打印二叉树
 * 层次打印二叉树
 */
public class Print {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Level Order Traversal:");
        ArrayList<Integer> list = Print_1(root);
        for (int i : list){
            System.out.println(i);
        }
    }

    /**
     * 层次打印
     * @param pRoot
     * @return
     */
    public static ArrayList<Integer> Print_1 (TreeNode pRoot) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        if(pRoot == null) return list;
        ArrayList<Integer> stack = new ArrayList<>();
//        ArrayList<TreeNode> que = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(pRoot);
        while (!que.isEmpty()){
            TreeNode p = que.poll();
            list.add(p.val);
            if(p.left!=null){
                que.offer(p.left);
            }
            if(p.right!=null){
                que.offer(p.right);
            }
        }
        return list;
    }

//    //按之字形顺序打印二叉树
//    static public ArrayList<ArrayList<Integer>> Print_2 (TreeNode pRoot) {
//        // write code here
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        if(pRoot == null) return list;
//        LinkedList<TreeNode> que = new LinkedList<>();
//        que.add(pRoot);
//        while (!que.isEmpty()){
//            ArrayList<Integer> tque = new ArrayList<>();
//            while (!que.isEmpty()){
//                TreeNode p = que.poll();
//                list.add(p.val);
//            }
//            TreeNode p = que.poll();
//            list.add(p.val);
//            if(p.left!=null){
//                que.offer(p.left);
//            }
//            if(p.right!=null){
//                que.offer(p.right);
//            }
//        }
//        return list;
//    }


    /**
     * 按之字形顺序打印二叉树
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode p = pRoot;
        s1.push(p);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!s1.isEmpty()) {
                    TreeNode t = s1.pop();
                    list.add(t.val);
                    if (t.left != null) {
                        s2.add(t.left);
                    }
                    if (t.right != null) {
                        s2.add(t.right);
                    }
                }
                res.add(list);
            }
            if (!s2.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!s2.isEmpty()) {
                    TreeNode t = s2.pop();
                    list.add(t.val);
                    // if (t.left != null){
                    //     s1.add(t.left);
                    // }
                    // if (t.right != null){
                    //     s1.add(t.right);
                    // }

                    if (t.right != null) {
                        s1.add(t.right);
                    }
                    if (t.left != null) {
                        s1.add(t.left);
                    }
                }
                res.add(list);
            }
        }
        return res;
    }

    /**
     * 把二叉树打印成多行
     * 写法 1 ， 写得不简洁
     */
    public ArrayList<ArrayList<Integer>> Print_3 (TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot==null)
            return res;

        Queue<TreeNode> que = new LinkedList<>();
        Queue<TreeNode> que2 = new LinkedList<>();
        que.offer(pRoot);
        while (!que.isEmpty() || !que2.isEmpty()){
            if(!que.isEmpty()){
                ArrayList<Integer> tList = new ArrayList<>();
                while (!que.isEmpty()){
                    TreeNode t = que.poll();
                    tList.add(t.val);
                    if(t.left!= null)
                        que2.offer(t.left);
                    if(t.right!=null)
                        que2.offer(t.right);
                }
                res.add(tList);
            }
            if(!que2.isEmpty()){
                ArrayList<Integer> tList = new ArrayList<>();
                while (!que2.isEmpty()){
                    TreeNode t = que2.poll();
                    tList.add(t.val);
                    if(t.left!= null)
                        que.offer(t.left);
                    if(t.right!=null)
                        que.offer(t.right);
                }
                res.add(tList);
            }
        }
        return res;
    }

    /**
     * 把二叉树打印成多行
     * 写法 2
     */
    ArrayList<ArrayList<Integer>> Print_4(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        if (pRoot == null) {
            return ret;
        }
        q.add(pRoot);
        while (!q.isEmpty()) {
            int sz = q.size();
            ArrayList<Integer> ans = new ArrayList<>();
            while (sz > 0) {
                TreeNode node = q.getFirst();
                q.removeFirst();
                ans.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                sz--;
            }
            ret.add(ans);
        }
        return ret;
    }
}
