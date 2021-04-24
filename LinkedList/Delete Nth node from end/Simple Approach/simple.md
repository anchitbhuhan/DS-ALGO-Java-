```java
public void removenNthNode(int n)
    {

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
```