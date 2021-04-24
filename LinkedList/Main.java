import java.util.*;
class Main{
    public static void main(String[] args)
    {

        Node head = new Node(1);
        LinkedList ll = new LinkedList(head);

        ll.insert(new Node(2));
        ll.insert(new Node(3));
        ll.insert(new Node(4));
        ll.insert(new Node(5));
        ll.insert(new Node(6));
        ll.traverse();
        ll.removenNthNode(6);
        ll.traverse();


    }
}

class Node
{
    int val;
    Node next;

    Node(int val)
    {
        this.val = val;
        this.next = null;
    }

    public String toString()
    {
        return val+"";
    }
}

class LinkedList
{
    Node head;
    
    LinkedList()
    {
        this.head = null;
    }

    LinkedList(Node head)
    {
        this.head = head;
    }

    public void traverse()
    {
        Node temp = head;
        if(temp != null)
        {
            while(temp != null)
            {
                System.out.print(temp.val+" ");
                temp = temp.next;
            }
            System.out.println();
        }
        else
        {
            System.out.println("Linked List is Empty");
        }
        
    }


    public void insert(Node node)
    {
        if(head==null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = node; 
        }
    }

    public void removenNthNode(int n)
    {

        // Node dummy = new Node(0);
        // dummy.next = head;
        // Node fast = dummy;
        // Node slow = dummy;
        // while(fast != null && n + 1 > 0) {
        //     fast = fast.next;
        //     n--;
        // }
        // while(fast != null) {
        //     fast = fast.next;
        //     slow = slow.next;
        // }
        // slow.next = slow.next.next;
        // head = dummy.next;


        int size= 0;
        Node temp = head;
        while(temp != null)
        {
            size++;
            temp = temp.next;
        }
        temp = head;
        
        if(size==1 && n==1)
            head = null;
        
        if(n>=size)
            head = head.next;
        else
        {
            int count = (size-n)-1;
            int inc = 0;
            while(inc != count && temp!= null)
            {
                inc++;
                temp = temp.next;
            }
            temp.next = temp.next.next; 
        }
    }



}