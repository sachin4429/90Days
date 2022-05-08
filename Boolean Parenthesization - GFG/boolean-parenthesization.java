// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
  static int helper(String S,int i,int j,boolean flag,Map<String,Integer> mp){
      
      if(i>j) return 0;
      
      if(i==j){
          if(flag==true){
              return (S.charAt(i)=='T') ? 1 : 0;
          }
          else{
              return (S.charAt(i)=='F') ? 1 : 0;
          }
      }
      
      StringBuilder sb=new StringBuilder();
      sb.append(Integer.toString(i));
      sb.append(" ");
      sb.append(Integer.toString(j));
      sb.append(" ");
      sb.append(Boolean.toString(flag));
      String temp=sb.toString();
      
      int ans=0;
      
      if(mp.containsKey(temp)){
          return mp.get(temp);
      }
      
      for(int k=i+1;k<j;k+=2){
          
          int lt=helper(S,i,k-1,true,mp);
          int lf=helper(S,i,k-1,false,mp);
          int rt=helper(S,k+1,j,true,mp);
          int rf=helper(S,k+1,j,false,mp);
          
          if(S.charAt(k)=='&'){
              if(flag==true){
                  ans+=(lt*rt);
              }
              else{
                  ans+=(lt*rf)+(rt*lf)+(rf*lf);
              }
          }
          
          else if(S.charAt(k)=='|'){
              if(flag==true){
                  ans+=(lt*rt)+(lt*rf)+(rt*lf);
              }
              else{
                  ans+=(lf*rf);
              }
          }
          
          else if(S.charAt(k)=='^'){
              if(flag==true){
                  ans+=(lt*rf)+(lf*rt);
              }
              else{
                  ans+=(lf*rf)+(rt*lt);
              }
          }
      }
      
      mp.put(temp,ans%1003);
      return mp.get(temp);
  }
  static int countWays(int N, String S){
      // code here
      Map<String,Integer> mp=new HashMap<>();
      return helper(S,0,S.length()-1,true,mp);
  }
}