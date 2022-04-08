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
            
            String a = S[0];
            String b = S[1];

            Solution ob = new Solution();
            System.out.println(ob.getLastDigit(a,b));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int getLastDigit(String a, String b) {
        if(b.length() == 1 && b.equals("0"))
            return 1;
        if(a.equals("1"))
            return 1;
        int exp = Modulo(4,b) == 0 ? 4 : Modulo(4,b);
        int res = (int)Math.pow(a.charAt(a.length()-1)-'0', exp);
        return res%10;
    }
    public static int Modulo(int a, String b)
    {
        int res = 0;
        for(int i = 0; i<b.length(); i++)
        {
            res = (res*10 + b.charAt(i)-'0')%a;
        }
        return res;
    }
};