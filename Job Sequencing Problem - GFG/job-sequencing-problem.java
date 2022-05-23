// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (j1,j2) -> j2.profit-j1.profit);
        int count = 0, max = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i<n; i++)
        {
            max = Math.max(arr[i].deadline,max);
        }
        int res[] = new int[max];
        for(int i = 0; i<n; i++)
        {
            if(res[arr[i].deadline-1] == 0)
            {
                res[arr[i].deadline-1] = arr[i].id;
                sum += arr[i].profit;
                count++;
            }
            else
            {
                for(int j=arr[i].deadline-1;j>=0;j--)
                {
                    if(res[j]==0)
                      {
                          res[j]=arr[i].id;
                          sum += arr[i].profit;
                          count++;
                          break;
                      }
                }
            }
        }
        return new int[]{count ,sum};
    }
}