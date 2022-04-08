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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String X, String Y) 
	{ 
	   int m = X.length();
	   int n = Y.length();
	   int t[][] = new int[m+1][n+1];
       for(int i = 1; i<m+1; i++)
        {
            for(int j = 1; j<n+1; j++)
            {
                if(X.charAt(i-1) == Y.charAt(j-1))
                    t[i][j] = 1+t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }
        return n-t[m][n] + m-t[m][n];
	   // int n = str1.length();
	   // int m = str2.length();
	   // int t[][] = new int[n+1][m+1];
	   // for(int i = 1; i<n+1; i++)
	   // {
	   //     for(int j = 1; i<m+1; j++)
	   //     {
	   //         if(str1.charAt(i-1) == str2.charAt(j-1))
	   //             t[i][j] = 1 + t[i-1][j-1];
	   //        else
	   //             t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
	   //     }
	   // }
	   // return n-t[n][m] + m-t[n][m];
	} 
}