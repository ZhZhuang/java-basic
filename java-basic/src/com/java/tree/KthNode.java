package com.java.tree;

import java.util.*;

public class KthNode {
    //保存结果
    private List<Integer> list = new ArrayList<>();

    public int KthNode (TreeNode proot, int k) {
        // write code here
        if(proot == null || k < 1){
            return -1;
        }
        dfs(proot, k);
        if(k > list.size()){
            return -1;
        }
        return list.get(k - 1);
    }


    /**
     * 左根右
     * @param root
     */
    public void dfs(TreeNode root, int k){
        if(root == null){
            return;
        }
        dfs(root.left, k);
        list.add(root.val);
        dfs(root.right, k);
    }

}
