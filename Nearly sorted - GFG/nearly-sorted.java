// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int num = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[num];
            for(int i = 0; i < num; i++)
                arr[i] = sc.nextInt();
            
            ArrayList <Integer> res = new Solution().nearlySorted(arr, num, k);
            for (int i = 0; i < res.size (); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0, j = 0; i<num; i++)
        {
            if(j<k)
            {
                pq.add(arr[i]);
                j++;
            }
            else
            {
                pq.add(arr[i]);
                j++;
                while(!pq.isEmpty())
                {
                    j--;
                    res.add(pq.remove());
                }
            }
        }
        
        while(!pq.isEmpty())
        {
            res.add(pq.remove());
        }
        return res;
    }
}
