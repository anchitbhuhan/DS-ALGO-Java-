```java
public void removeDuplicates()
    {
        Node dummy = new Node(0);
        dummy.next = head;
        Node curr = dummy;

        while(curr != null)
        {
            Node temp = curr;

            while(temp.next != null && temp.val == temp.next.val )
            {
                temp = temp.next;
            }

            curr.next = temp.next;
            curr = curr.next;
        }

    }
```