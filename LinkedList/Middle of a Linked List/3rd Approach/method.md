```java
    public Node middle()
    {
        int count = 0;
        Node mid = head;
        Node temp = head;
        
        if(head != null)
        {

            while(temp.next != null)
            {
                if(count%2 != 0)
                    mid  = mid.next;
                count++;
                temp = temp.next;
            }
            return mid;
        }
        return null;
    }
```