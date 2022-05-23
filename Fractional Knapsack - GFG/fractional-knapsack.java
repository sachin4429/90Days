// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        double w = (double)W;
        int i;
        double res = 0;
        
        double [][] tem = new double[n][3];
        
        for(i=0;i<n;i++)
        {
            tem[i][0] = (double)arr[i].value / (double)arr[i].weight;
            tem[i][1] = arr[i].value;
            tem[i][2] = arr[i].weight;
        }
        Arrays.sort(tem, (a, b) -> -Double.compare(a[0], b[0]));
        for(i=0;i<n;i++)
        {
            if(w==0)
                break;
            else if(tem[i][2]<=w)
            {
                res+=tem[i][1];
                w = w-tem[i][2];
            }
            else
            {
                res += tem[i][0] * w;
                break;
            }
        }
        
        return res;
    }
}