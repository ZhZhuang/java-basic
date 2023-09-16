package com.java.tree;


//前序遍历和中序遍历结果，构造一个二叉树
public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int [] pre, int [] vin) {
        //合法性校验
        if (pre == null || vin == null || pre.length != vin.length) {
            return null;
        }
        return solveHelper(pre, 0, pre.length - 1, vin, 0, vin.length - 1);
    }

    TreeNode solveHelper(int[] pre, int pre_start, int pre_end,
                         int[] vin, int vin_start, int vin_end) {
        if (pre_start > pre_end || vin_start > vin_end) {
            return null;
        }
        TreeNode root = new TreeNode(pre[pre_start]);

        for (int i = vin_start; i <= vin_end; i++) {
            if (vin[i] == pre[pre_start]) {
                root.left = solveHelper(pre, pre_start + 1, pre_start + i - vin_start, vin,
                        vin_start, i - 1);
                root.right = solveHelper(pre, pre_start + i - vin_start + 1, pre_end, vin,
                        i + 1, vin_end);
                break;
            }
        }
        return root;
    }

}
