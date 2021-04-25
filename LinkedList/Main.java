import java.util.*;
class Main{
    public static void main(String[] args)
    {

        Node head = new Node(1);
        LinkedList ll = new LinkedList(head);

        ll.insert(new Node(1));
        ll.insert(new Node(1));
        ll.insert(new Node(1));
        ll.insert(new Node(1));
        ll.insert(new Node(1));
        ll.insert(new Node(1));
        ll.insert(new Node(1));
        ll.insert(new Node(2));
        ll.insert(new Node(3));
        ll.insert(new Node(3));
        ll.traverse();
        ll.removeAllDuplicates();
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


    public void removeAllDuplicates()
    {
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;

        while(curr != null)
        {
            while(curr.next != null && prev.next.val == curr.next.val )
                curr = curr.next;

            if(prev.next==curr)
                prev = prev.next;
            else
                prev.next = curr.next;
            curr = curr.next;
        }

        head = dummy.next;

    }


}