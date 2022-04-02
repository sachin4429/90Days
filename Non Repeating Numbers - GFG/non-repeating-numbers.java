// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
       int x = 0, a = 0, b = 0;
        for (int k : nums)
            x ^= k;
        x = x & ~(x - 1);
        for (int k : nums) {
            int y = k&x;
            if (y != 0) a ^= k;
            else b ^= k;
        }
        int arr[] = new int[2];
        if (a < b) 
        {
            arr[0] = a;
            arr[1] = b;
        }
        else
        {
            arr[0] = b;
            arr[1] = a;
        }
        return arr;
    }
}