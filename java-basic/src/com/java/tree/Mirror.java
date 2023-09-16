package com.java.tree;

public class Mirror {
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot==null){
            return null;
        }
        TreeNode Temp= pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = Temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}
