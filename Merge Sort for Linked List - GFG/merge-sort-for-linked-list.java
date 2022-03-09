// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}


// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
     //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        if(head.next == null || head == null)
        return head;
        
        Node midNode = mid(head);
        Node leftLL = head;
        Node rightLL = midNode.next;
        midNode.next = null;
        
        leftLL = mergeSort(leftLL);
        rightLL = mergeSort(rightLL);
        Node result = merge(leftLL,rightLL);
        
         return result;
        
    }
    static Node mid(Node head){
        Node fast = head;
        Node slow = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
     static Node merge(Node h1, Node h2)
    {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
 
        // start with the linked list
        // whose head data is the least
        if (h1.data < h2.data)
            return mergeUtil(h1, h2);
        else
            return mergeUtil(h2, h1);
    }
    
     static Node mergeUtil(Node h1, Node h2)
    {
        // if only one node in first list
        // simply point its head to second list
        if (h1.next == null) {
            h1.next = h2;
            return h1;
        }
 
        // Initialize current and next pointers of
        // both lists
        Node curr1 = h1, next1 = h1.next;
        Node curr2 = h2, next2 = h2.next;
 
        while (next1 != null && curr2 != null) {
            // if curr2 lies in between curr1 and next1
            // then do curr1->curr2->next1
            if ((curr2.data) >= (curr1.data) && (curr2.data) <= (next1.data)) {
                next2 = curr2.next;
                curr1.next = curr2;
                curr2.next = next1;
 
                // now let curr1 and curr2 to point
                // to their immediate next pointers
                curr1 = curr2;
                curr2 = next2;
            }
            else {
                // if more nodes in first list
                if (next1.next != null) {
                    next1 = next1.next;
                    curr1 = curr1.next;
                }
 
                // else point the last node of first list
                // to the remaining nodes of second list
                else {
                    next1.next = curr2;
                    return h1;
                }
            }
        }
        return h1;
    }   
}


