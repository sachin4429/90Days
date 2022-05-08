// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
   static int countWays(int n, String s){
       HashMap<String, Integer> mp = new HashMap<>();
       int res = solve(s,0,n-1,true,mp)%1003;
       //System.out.println(mp);
       return res;
   }
   static int solve(String s, int i, int j, boolean istrue, HashMap<String, Integer> mp)
   {
       if(i>j)
           return 0;
       if(i==j)
       {
           if(istrue == true)
               return s.charAt(i) == 'T' ? 1:0;
           else
               return s.charAt(i) == 'F' ? 1:0;
       }
       String sb = String.valueOf(i)+String.valueOf(j)+String.valueOf(istrue);
       if(mp.containsKey(sb))
           return mp.get(sb);
       int ans = 0;
       for(int k = i+1; k<=j-1; k+=2)
       {
           int lt = solve(s,i,k-1,true,mp);
           int lf = solve(s,i,k-1,false,mp);
           int rt = solve(s,k+1,j,true,mp);
           int rf = solve(s,k+1,j,false,mp);
           if(s.charAt(k)=='&')
           {
               if(istrue == true)
                   ans += lt*rt;
               else
                   ans += lf*rf + lf*rt + lt*rf;
           }
           else if(s.charAt(k)=='|')
           {
               if(istrue == true)
                   ans += lt*rt + lf*rt + lt*rf;
               else
                   ans += lf*rf;
           }
           else if(s.charAt(k)=='^')
           {
               if(istrue == true)
                   ans += lf*rt + lt*rf;
               else
                   ans += lf*rf + lt*rt;
           }
       }
       ans = ans%1003;
       mp.put(sb,ans);
       return ans%1003;
   }
}