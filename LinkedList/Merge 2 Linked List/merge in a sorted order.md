```java
public Node mergeTwoLists(Node A, Node B) {
        
        Node temp1 = A;
        Node temp2 = B;
        Node res = new Node(0);
        
        Node result = res;
        while(temp1 != null && temp2 != null)
        {
            if(temp1.val <= temp2.val)
            {
                result.next = temp1;
                temp1 = temp1.next;
            }
            else
            {
                result.next = temp2;
                temp2 = temp2.next;
            }
            result  = result.next;
        }
        if(temp1 == null)
            result.next = temp2;
        if(temp2==null)
            result.next = temp1;
        return res.next;
    }
```