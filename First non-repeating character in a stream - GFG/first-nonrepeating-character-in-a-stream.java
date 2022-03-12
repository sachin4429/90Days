// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
         HashMap<Character,Integer> map = new HashMap<>();
       Queue<Character>q = new LinkedList<>();
       StringBuilder sb = new StringBuilder("");
       
       for(int i=0;i<A.length();i++){
           char ch = A.charAt(i);
           
           if(map.containsKey(ch) == false ){
               map.put(ch,1);
               q.add(ch);
           }
           else{
               map.put(ch,2);
           }
           
           while(q.size()>0 && map.get(q.peek()) != 1){
               q.poll();
           }
           
           if(q.size() == 0){
               sb.append('#');
           }else{
               sb.append(q.peek());
           }
           
       }
       
       return sb.toString();
    }
}