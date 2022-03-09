// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
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
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        Solution s=new Solution();
        Node head1=s.reverse(first);
        Node head2=s.reverse(second);
        Node res = new Node(-1);
        Node ans = res;
        int carry=0;
        while(head1!=null && head2!=null)
        {
            int sum=head1.data+head2.data+carry;
            carry=sum/10;
            sum=sum%10;
            res.next=new Node(sum);
            res=res.next;
            head2=head2.next;
            head1=head1.next;
        }
        while(head1!=null)
        {
            int m=head1.data+carry;
            carry=m/10;
            m=m%10;
            res.next=new Node(m);
            res=res.next;
            head1=head1.next;
        }
        while(head2!=null)
        {
            int m=head2.data+carry;
            carry=m/10;
            m=m%10;
            res.next=new Node(m);
            res=res.next;
            head2=head2.next;
        }
        if(carry>0)
        {
            res.next=new Node(carry);
        }
        Node fin=s.reverse(ans.next);
        return fin;
    }
}