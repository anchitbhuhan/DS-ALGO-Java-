```java
public void reverse(Node node)
    {
        if(node.next==null)
        {
            head = node;
            return;
        }
        else
        {
                reverse(node.next);
                Node q = node.next;
                q.next = node;
                node.next = null;
        }
    }
```