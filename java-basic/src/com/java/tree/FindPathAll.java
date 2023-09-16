package com.java.tree;

import java.util.*;

// 有难度
// 返回所有的路径，路径和为target
public class FindPathAll {

    ArrayList<ArrayList<Integer>> list;
    ArrayList<Integer> templist;

    public ArrayList<ArrayList<Integer>> FindPath (TreeNode root, int target) {
        // write code here
        list = new ArrayList<>();
        templist = new ArrayList<>();
        dfs(root,target);
        return list;
    }
    void dfs(TreeNode root, int target){
        if (root == null){
            return;
        }
        templist.add(root.val);
        target-=root.val;
        if(root.left ==null && root.right==null && target==0)
            // 注意此处
            list.add(new ArrayList<>(templist));
        dfs(root.left,target);
        dfs(root.right,target);
        templist.remove(templist.size()-1);



    }
}
