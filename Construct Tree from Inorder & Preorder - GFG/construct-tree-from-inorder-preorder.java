// { Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends


class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {   HashMap<Integer,Integer>map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }   
        return getvalue(inorder,0,inorder.length-1,preorder,0,preorder.length-1,map);
    }
    public static Node getvalue(int inorder[],int si ,int ei,int preorder[],int sp,int ep,HashMap<Integer,Integer>map){
        if(sp>ep)return null;
        Node root = new Node(preorder[sp]);
        int idx = map.get(preorder[sp]);
        int x = idx-si+sp;
        root.left = getvalue(inorder,si,idx-1,preorder,sp+1,x,map);
        root.right = getvalue(inorder,idx+1,ei,preorder,x+1,ep,map);
        return root;
    }
}
