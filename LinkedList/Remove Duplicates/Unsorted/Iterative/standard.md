```java
public void removeDuplicates()
    {
        Node dummy = new Node(0);
        dummy.next = head;
        Node temp = dummy;
        

        while(temp != null)
        {
            Node temp2 = temp;

            while(temp2.next != null)
            {

                if(temp.val == temp2.next.val)
                    temp2.next = temp2.next.next;
                else
                    temp2 = temp2.next;

            }
            temp = temp.next;
        }


    }

```