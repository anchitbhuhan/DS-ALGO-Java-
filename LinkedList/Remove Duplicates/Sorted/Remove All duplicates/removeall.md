```java
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
```