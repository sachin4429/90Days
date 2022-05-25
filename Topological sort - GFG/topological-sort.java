// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Solution
 {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int res[]=new int[V];
        int indegree[]=new int[V];
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<V;i++)
        for(int u:adj.get(i)) indegree[u]++;
        for(int i=0;i<V;i++) if(indegree[i]==0) q.add(i);
        int j=0;
        while(!q.isEmpty()){
            int u=q.poll();
            res[j++]=u;
            for(int v:adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0) q.add(v);
            }
        }
        return res;
    }
 }

// class Solution
// {
//     //Function to return list containing vertices in Topological order. 
//     static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
//     {
//         int topo[] = new int[V];
//         int indegree[] = new int[V];
//         for(int i=0; i<V; i++)
//         {
//             for(Integer it : adj.get(i))
//             {
//                 indegree[it]++;
//             }
//         }
//         Queue<Integer> q = new LinkedList<Integer>();
//         for(int i = 0; i<V; i++)
//         {
//             if(indegree[i] == 0)
//                 q.add(i);
//         }
//         int ind = 0;
//         while(!q.isEmpty())
//         {
//             Integer node = q.poll();
//             topo[ind++] = node;
//             for(Integer it : adj.get(node))
//             {
//                 indegree[it]--;
//                 if(indegree[it] == 0)
//                     q.add(it);
//             }
//         }
//         return topo;
//     }
// }

// class Solution
// {
//     //Function to return list containing vertices in Topological order. 
//     static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
//     {
//         Stack<Integer> res = new Stack<Integer>();
//         int vis[] = new int[V];
//         for(int i = 0; i<V; i++)
//         {
//             if(vis[i] == 0)
//                 findtoposort(i,vis,adj,res);
//         }
//         int topo[] = new int[V];
//         int ind = 0;
//         while(!res.isEmpty())
//         {
//             topo[ind++] = res.pop();
//         }
//         return topo;
//     }
//     static void findtoposort(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> res)
//     {
//         vis[node] = 1;
//         for(Integer it : adj.get(node))
//         {
//             if(vis[it] == 0)
//                 findtoposort(it,vis,adj,res);
//         }
//         res.push(node);
//     }
// }
