```java
    public void removeDuplicates()
    {
        LinkedHashSet<Integer> lh = new LinkedHashSet<>();
        Node curr = head;
        Node prev = null;
        while(curr != null)
        {   
            int currentVal = curr.val;
            if(lh.contains(currentVal))
                prev.next = curr.next;
            else
            {
                lh.add(currentVal);
                prev = curr;
            }
            curr = curr.next;
        }

    }

```