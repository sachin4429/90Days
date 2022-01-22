// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}// } Driver Code Ends


//User function Template for Java

// 
class Solution {
   static ArrayList<Integer> factorial(int N){
       //code here
       ArrayList<Integer> ans = new ArrayList<>();
       java.math.BigInteger f = new java.math.BigInteger("1"); 
       java.math.BigInteger ten = new java.math.BigInteger("10");
       for (int i = 2; i <= N; i++)
           f = f.multiply(java.math.BigInteger.valueOf(i));
       
       while(!f.equals(new java.math.BigInteger("0"))){
           java.math.BigInteger k = f.mod(ten);
           ans.add(0,k.intValue());
           f = f.divide(ten);
       }
       return ans;
   }
}