// { Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
   // Function to find maximum product subarray
   long maxProduct(int[] arr, int n) {
       

//start with the first element
       long result = arr[0];
       long curMax = 1, curMin = 1;

       for(long i=0; i<n; i++){

           long num = arr[(int) i];

// if num is 0 we ignore ,coz it affects our calculation. eg[0,2,3]
           if(num ==0){
               curMax = curMin =1;
               continue;
           }


           long temp = num*curMax;
           curMax = Math.max(Math.max(num*curMax, num*curMin), num);
           curMin = Math.min(Math.min(temp, num*curMin),num);


           result = Math.max(curMax,result);

       }

       return result;
   }
}