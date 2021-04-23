```java
    public Node middle()
    {
        Node fast_ptr = head;
        Node slow_ptr = head;

        if(head != null)
        {
            while(fast_ptr.next != null && fast_ptr.next.next != null)
            {
                slow_ptr = slow_ptr.next;
                fast_ptr = fast_ptr.next.next;
            }

            return slow_ptr;
        }
        return null;
    }
```