package com.company.Contests.LeetCode.Augest_LeetCoding_Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Week5 {

    // Day 29: Pancake Sorting

    /**
     *  Given an array of integers A, We need to sort the array performing a series of pancake flips.
     In one pancake flip we do the following steps:
     Choose an integer k where 0 <= k < A.length.
     Reverse the sub-array A[0...k].
     For example, if A = [3,2,1,4] and we performed a pancake flip choosing k = 2, we reverse
     the sub-array [3,2,1], so A = [1,2,3,4] after the pancake flip at k = 2.
     Return an array of the k-values of the pancake flips that should be performed in order to sort A. Any valid
     answer that sorts the array within 10 * A.length flips will be judged as correct.*/

    void rev(int[] a, int i, int j){
        while(i<j){
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++; j--;
        }
    }

    int find(int[] a, int n){
        for(int i=0; i<a.length; i++)
            if(a[i] == n)
                return i;
        return 0;
    }

    public List<Integer> pancakeSort(int[] a) {

        List<Integer> result = new ArrayList<>();
        // each round, flip the n to the 0 index then flip to the n-1index.
        for(int n = a.length; n >= 1; n--){
            int idx = find(a, n);
            if(idx+1 == n) continue; // skip when the n already in n-1 index
            result.add(idx + 1);
            rev(a, 0, idx);
            result.add(n);
            rev(a, 0, n-1);
        }
        return result;
    }




    // Day 30: Largest Component Size by Common Factor
    /** Given a non-empty array of unique positive integers A, consider the following graph:
     There are A.length nodes, labelled A[0] to A[A.length - 1];
     There is an edge between A[i] and A[j] if and only if A[i] and
     A[j] share a common factor greater than 1.
     Return the size of the largest connected component in the graph.
     */

    public int find(int x,int[] parent){
        if(parent[x]==-1)
            return x;
        else
            parent[x]=find(parent[x],parent);
        return parent[x];
    }
    public void union(int x,int y,int[] parent){
        int xp=find(x,parent);
        int yp=find(y,parent);
        if(xp!=yp)
        {
            parent[yp]=xp;
        }
        return;
    }
    public int largestComponentSize(int[] nums) {
        int[] parent=new int[100001];
        Arrays.fill(parent,-1);
        int i;
        for(i=0;i<nums.length;i++)
        {
            for(int k=2;k<=Math.sqrt(nums[i]);k++)
            {
                if(nums[i]%k==0)
                {
                    union(nums[i],k,parent);
                    union(nums[i],nums[i]/k,parent);
                }
            }
        }
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(i=0;i<nums.length;i++)
        {
            int p=find(nums[i],parent);
            count=Math.max(count,map.getOrDefault(p,0)+1);
            map.put(p,map.getOrDefault(p,0)+1);
        }
        return count;
    }


    // Day 31: delete node in a bst
    /**
     * Given a root node reference of a BST and a key, delete the
     * node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
        Basically, the deletion can be divided into two stages:
        Search for a node to remove.
        If the node is found, delete the node.
                Note: Time complexity should be O(height of tree).

    }*/
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode inPre(TreeNode root)
    {
        while(root!=null && root.right!=null)
        {
            root=root.right;
        }
        return root;
    }
    public TreeNode inSuc(TreeNode root)
    {
        while(root!=null && root.left!=null)
        {
            root=root.left;
        }
        return root;
    }
    public int height(TreeNode root)
    {
        int x,y;
        if(root!=null)
        {
            x=height(root.left);
            y=height(root.right);
            if(x>y)
                return x+1;
            else
                return y+1;
        }
        else
            return 0;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode q;
        if(root==null)
            return null;
        if(key<root.val)
        {
            root.left=deleteNode(root.left,key);
        }
        else if(key>root.val)
        {
            root.right=deleteNode(root.right,key);
        }
        else
        {
            if(root.left!=null && root.right!=null)
            {
                if(height(root.left)>=height(root.right))
                {
                    q=inPre(root.left);
                    root.val=q.val;
                    root.left=deleteNode(root.left,q.val);
                }
                else if(height(root.left)<height(root.right))
                {
                    q=inSuc(root.right);
                    root.val=q.val;
                    root.right=deleteNode(root.right,q.val);
                }
            }
            else if(root.left!=null)
            {
                root=root.left;
            }
            else if(root.right!=null)
            {
                root=root.right;
            }
            else
                root=null;
        }
        return root;

    }
}
