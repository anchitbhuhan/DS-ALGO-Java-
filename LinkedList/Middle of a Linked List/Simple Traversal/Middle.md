```java
public Node middle()
    {
        Node temp = head;
        int size = 0;
        if(head != null)
        {
            while(temp.next != null)
            {
                temp = temp.next;
                size++;
            }
    
            temp = head;
            int count = 0;
            while(temp.next != null && count != size/2)
            {
                temp = temp.next;
                count++;
            }
            return temp;

        }
        return null;
    }
```