```java
   void reverse()
    {
        Stack<Node> stack = new Stack<>();

        Node temp = head;
        while(temp.next != null)
        {
            stack.add(temp);
            temp = temp.next;
        }
        
        head = temp;
        
        while(!stack.isEmpty())
        {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next =  null;
    }
```