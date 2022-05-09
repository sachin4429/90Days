// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}


// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int[][] t = new int[201][201];
    static int eggDrop(int n, int k) 
	{
	    // Your code here
	    for(int i = 0; i<201; i++)
	    {
	        for(int j = 0; j<201; j++)
	        {
	            t[i][j] = -1;
	        }
	    }
	    return solve(n,k);
	}
	static int solve(int e, int f)
	{
	    if(f==0 || f==1 || e==1)
	        return f;
	        if(t[e][f] != -1)
	            return t[e][f];
	    int mn = Integer.MAX_VALUE;
	    for(int k = 1; k<=f; k++)
	    {
	        int temp = 1+Math.max(solve((e-1),(k-1)), solve(e,(f-k)));
	        mn = Math.min(mn, temp);
	    }
	    return t[e][f] = mn;
	}
}