import java.util.*;
public class DAY1_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        sort012(arr, n);
        in.close();
    }
    public static void sort012(int a[], int n)
    {
        int zero = 0, one = 0, two = 0;
        for(int k : a)
        {
            if(k == 0)
                zero++;
            if(k == 1)
                one++;
            if(k == 2)
                two++;
        }
        for(int i = 0; i<zero; i++)
        {
            System.out.print("0 ");
        }
        for(int i = 0; i<one; i++)
        {
            System.out.print("1 ");
        }
        for(int i = 0; i<two; i++)
        {
            System.out.print("2 ");
        }
            
    }   
}
