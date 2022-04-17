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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] t = new int[501][501];
    static int palindromicPartition(String s)
    {
        for(int i = 0; i<501; i++)
        {
            for(int j = 0; j<501; j++)
            {
                t[i][j] = -1;
            }
        }
        return solve(s,0,s.length()-1);
    }
    static boolean ispalindrome(String s,int start,int end)
    {
          for(int i=start, j=end; i<j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    static int solve(String s, int i, int j)
    {
        if(t[i][j] != -1)
            return t[i][j];
        if(i>=j)
            return 0;
        if(ispalindrome(s,i,j))
            return 0;
        int mn = Integer.MAX_VALUE;
        for(int k = i; k<j; k++)
        {
            int temp = 1 + solve(s,i,k) + solve(s,k+1,j);
            mn = Math.min(temp, mn);
        }
        return t[i][j] = mn;
    }
}