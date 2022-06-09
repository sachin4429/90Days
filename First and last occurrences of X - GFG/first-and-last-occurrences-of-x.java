// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            String inputLine[] = br.readLine().trim().split(" "); 
            int n = Integer.parseInt(inputLine[0]); 
            int x = Integer.parseInt(inputLine[1]);
            
            int arr[] = new int[(int)(n)];
            
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine1[i]);
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.firstAndLast(arr, n, x); 
            
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    } 
} 
            


// } Driver Code Ends


//User function Template for Java
class Solution{
    public ArrayList<Integer> firstAndLast(int arr[], int n, int x){
        // Code here
          ArrayList<Integer> a1 = new ArrayList<Integer>();
        int a = firstOcc(arr,n,x);
		int b  = lastOcc(arr,n,x);
		if(a == -1 && b == -1)
		{
		    a1.add(-1);
		    return a1;
		}
        a1.add(a);
        a1.add(b);
        return a1;
    }
    
    public static int firstOcc(int[] arr,int n,int x){
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>x){
                high = mid-1;
            } else if(arr[mid]<x){
                low = mid+1;
            } else{
                if(mid==0 || arr[mid-1]!=arr[mid]){
                    return ans = mid;
                } else {
                    high = mid-1;
                }
            }
        }
        return ans;
    }
    
    
     public static int lastOcc(int[] arr,int n,int x){
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
              
            if(arr[mid]>x){
                high = mid-1;
            } else if(arr[mid]<x){
                low = mid+1;
            } else{
                if(mid == n-1 || arr[mid+1]!=arr[mid]){
                    return ans = mid;
                } else {
                    low = mid+1;
                }
            }
        }
        return ans;
    }
}