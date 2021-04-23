```java
public void reverse()
    {
        Node next = head;
        Node prev = null;
        Node current = head;

        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current; 
            current  = next;
        }
        head = prev;
    }
```