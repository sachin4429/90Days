// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int maximumSumSubarray(int k, ArrayList<Integer> Arr,int N){
        int i = 0, j =0, sum = 0, max = Integer.MIN_VALUE;
        while(j<N)
        {
            sum += Arr.get(j);
            if(j-i+1 < k)
                j++;
            else if(j-i+1 == k)
            {
                max = Math.max(sum,max);
                sum -= Arr.get(i);
                i++;
                j++;
            }
        }
        return max;
    }
}