// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node 
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class SortLL
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) 
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            
            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);
            
            printList(node);
            System.out.println();
        }
    }
    public static void printList(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static void addToTheLast(Node node) 
{
  if (head == null) 
  {
    head = node;
  } else 
  {
   Node temp = head;
   while (temp.next != null)
          temp = temp.next;
         temp.next = node;
  }
}
}// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
}*/
// you have to complete this function
class GfG{
   
   static class Triplet{
       Node left,pivot,right;
       Triplet(Node left, Node pivot, Node right){
           this.left = left;
           this.pivot = pivot;
           this.right = right;
       }
   }
   
   static Triplet getPivot(Node head){
       Node pivot = head;
       head = head.next;
       pivot.next = null;
       Node left = new Node(0);
       Node right = new Node(0);
       Node lptr = left;
       Node rptr = right;
       while(head!=null){
           if(head.data<pivot.data){
               lptr.next = head;
               lptr = lptr.next;
           }else{
               rptr.next = head;
               rptr = rptr.next;
           }
           head = head.next;
       }
       if(lptr!=null) lptr.next = null;
       if(rptr!=null) rptr.next = null;
       return new Triplet(left.next,pivot,right.next);
   }
   
   public static Node quickSort(Node node){
       //Your code here
       if(node==null || node.next==null) return node;
       Triplet curr = getPivot(node);
       curr.left = quickSort(curr.left);
       curr.right = quickSort(curr.right);
       curr.pivot.next = curr.right;
       if(curr.left==null) return curr.pivot;
       Node temp = curr.left;
       while(temp.next!=null) temp = temp.next;
       temp.next = curr.pivot;
       return curr.left;
   }
}