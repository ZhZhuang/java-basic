package com.java.tree;


// 仔细看，不简单
public class KthNode_2 {
    int res = -1;
    int cur = 0;
    public int KthNode (TreeNode proot, int k) {
        dfs(proot, k);
        return res;
        // write code here
    }

    private void dfs(TreeNode proot, int k) {
        if (proot == null || res != -1) return;
        // write code here
        KthNode(proot.left, k);
        ++cur;
        if (cur == k) {
            res = proot.val;
        }
        KthNode(proot.right, k);
    }
}
