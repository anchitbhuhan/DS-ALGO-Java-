```java
public void removenNthNode(int n)
    {

        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;
        while(fast != null && n + 1 > 0) {
            fast = fast.next;
            n--;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        head = dummy.next;
    }
```