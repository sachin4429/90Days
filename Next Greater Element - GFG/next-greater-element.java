// { Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}



// } Driver Code Ends


class Solution
{
    public static long[] nextLargerElement(long[] arr, int n)
    {
               long[] ans = new long[n];
               Stack<Integer> st = new Stack<>();
               Arrays.fill(ans, -1);
               
               for(int i=0; i<n; i++){
                   if(st.isEmpty()) st.push(i);
                   else if(arr[i] <= arr[st.peek()]) st.push(i);
                   else{
                       while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                           ans[st.peek()] = arr[i];
                           st.pop();
                       }
                       st.push(i);
                   }
               }
               
               return ans;
        // long[] al = new long[n];
        // Stack<Integer> s = new Stack<Integer>();
        // for(int i = n-1; i>=0; i--)
        // {
        //     if(s.size()==0)
        //         al[i] = -1;
        //     else if(s.size()>0 && s.peek()>arr[i])
        //         al[i] = s.peek();
        //     else if(s.size()>0 && s.peek()<=arr[i])
        //     {
        //         while(s.size()>0 && s.peek() <= arr[i])
        //             s.pop();
        //         if(s.size() == 0)
        //             al[i] = -1;
        //         else
        //             al[i] = s.peek();
        //     }
        //     s.push((int)arr[i]);
        // }
        // return al;
    } 
}