import java.util.*;
/**
 * 1_5
 */
public class DAY1_5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) 
        {
            arr[i] = in.nextInt();
        }
        int i = 0,j = n-1, temp;
        while(i<j) {
            //System.out.println(arr[i]+ " " +arr[j]);
            if (arr[i] > 0 && arr[j] < 0) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            else if(arr[i] > 0 && arr[j] > 0)
            {
                j--;
            }
            else if(arr[i] < 0 && arr[j] < 0)
            {
                i++;
            }
            if (arr[i] < 0 && arr[j] > 0) {
                i++;
                j--;
            }
        }
        for (int k : arr) {
            System.out.print(k+" ");
        }
        in.close();
    }
}