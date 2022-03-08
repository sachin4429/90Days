// { Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
        //code here.
    Node reverse(Node head)
    {
        Node curr=head;
        Node prev=null;
        while(curr!=null)
        {
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            
        }
        return prev;
    }
    
    public static Node addOne(Node head) 
    { 
        Solution s=new Solution();
        Node head1=s.reverse(head);
        Node prev=null;
        Node curr=head1;
        int carry=1;
        while(head1!=null)
        {
            int sum=head1.data+carry;
            carry=sum/10;
            sum=sum%10;
            head1.data=sum;
            prev=head1;
            head1=head1.next;
        }
        if(carry>0)
        {
            prev.next=new Node(carry);
        }
        Node res=s.reverse(curr);
        return res;
    }
}
