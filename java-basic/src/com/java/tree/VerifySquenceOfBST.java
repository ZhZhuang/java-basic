package com.java.tree;

// 难度：写起来比较麻烦
// 写出思路：
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return Verify(sequence,0,sequence.length - 1);
    }
    public boolean Verify(int[] sequence,int first,int last){
        if(last - first <= 0){
            return true;
        }
        int root = sequence[last];
        int cutpoint = first;
        while(cutpoint < last && sequence[cutpoint] <= root){
            cutpoint++;
        }
        for(int i = cutpoint;i <= last;i++){
            if(sequence[i] < root){
                return false;
            }
        }
        return Verify(sequence,first,cutpoint - 1) && Verify(sequence,cutpoint,last - 1);
    }


//    public boolean helper(int [] sequence) {
//        if(sequence.length == 0)
//            return true;
//        //找到左右的分界点
//        int i =0;
//        for (i =0;i<sequence.length-1;i++){
//            if(sequence[i]>sequence[-1]){
//                break;
//            }
//        }
//        // 左边都有小于根节点
//        for (int j=0;j<i;j++){
//            if(sequence[j]>sequence[-1])
//                return false;
//        }
//        // 右边都大于根节点
//        for (int j=i;j<sequence.length-1;j++){
//            if(sequence[j]<sequence[-1])
//                return false;
//        }
//        return helper();
//    }
}
