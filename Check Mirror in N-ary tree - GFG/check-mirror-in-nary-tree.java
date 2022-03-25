// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int e = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[2*e];
            int[] B = new int[2*e];
            
            for(int i=0; i<2*e; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.checkMirrorTree(n,e,A,B));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkMirrorTree(int n, int e, int[] arr1, int[] arr2) {
        // code here
        Map<Integer,Stack<Integer>> hs=new LinkedHashMap<>();
        for(int i=1;i<2*e;i+=2){
            Stack<Integer> st=hs.getOrDefault(arr1[i-1],new Stack<>());
            st.push(arr1[i]);
            hs.put(arr1[i-1],st);
        }
        for(int i=1;i<2*e;i+=2){
            Stack<Integer> st=hs.getOrDefault(arr2[i-1],new Stack<>());
                int ele=-1;
                if(st.size()>0)
                ele=st.peek();
                if(ele!=arr2[i]) return 0;
                else{
                    st.pop();
                }
            hs.put(arr2[i-1],st);
        }
        return 1;
    }
};