import java.util.*;
class Main{
    public static void main(String[] args)
    {

        Node head = new Node(1);
        LinkedList ll = new LinkedList(head);

        ll.insert(new Node(1));
        ll.insert(new Node(1));
        ll.insert(new Node(1));
        ll.insert(new Node(3));
        ll.insert(new Node(4));
        ll.insert(new Node(1));
        ll.insert(new Node(10));
        ll.insert(new Node(2));
        ll.insert(new Node(3));
        ll.insert(new Node(4));
        ll.insert(new Node(4));
        ll.insert(new Node(4));
        ll.traverse();
        ll.removeDuplicates();
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

    public int hashCode()
    {
        return val;
    }

    public boolean equals(Object o)
    {
        Node obj = (Node)o;
        if(obj.val == this.val)
            return true;
        return false;
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


    public void removeDuplicates()
    {
        Node dummy = new Node(0);
        dummy.next = head;
        Node temp = dummy;
        

        while(temp != null)
        {
            Node temp2 = temp;

            while(temp2.next != null)
            {

                if(temp.val == temp2.next.val)
                    temp2.next = temp2.next.next;
                else
                    temp2 = temp2.next;

            }
            temp = temp.next;
        }


    }


}