#include <iostream>
using namespace std;

struct Node
{
    int data;
    Node *next;
};

class LinkedList
{
public:
    Node *head;
    Node* reverseHead;
    Node* temp;

public:
    LinkedList()
    {
        head = NULL;
    }

    // inserting elements (At end of the list)
    void insert(int val)
    {
        Node *new_node = new Node;
        new_node->next = NULL;
        new_node->data = val;

        if (head == NULL)
            head = new_node;
        else
        {
            Node *temp = head;
            while (temp->next != NULL)
            {
                temp = temp->next;
            }
            temp->next = new_node;
            new_node->next = NULL;
        }
    }

    void print(Node *head)
    {
        Node *temp = head;
        while (temp != NULL)
        {
            cout << temp->data << " ";
            temp = temp->next;
        }
        cout << endl;
    }

    void reverseList(Node* head)
    {
        if(head==NULL)
            return;
        reverse(head);
        temp->next = NULL;
        this->head = reverseHead;
    }

    void reverse(Node* node)
    {
        if(node->next == NULL)
        {
            reverseHead = node;
            temp = reverseHead;
        }
        else
        {
            reverse(node->next);
            temp->next = node;
            temp = node;
        }
    }


};

int main()
{
    LinkedList ll;

    ll.insert(1);
    ll.insert(2);
    ll.insert(3);
    ll.insert(4);
    ll.insert(5);
    ll.insert(6);

    ll.print(ll.head);
    cout << "Reverse Linked List" << endl;
    ll.reverseList(ll.head);
    ll.print(ll.head);

    cout << "Again Reversing" << endl;
    ll.reverseList(ll.head);
    ll.print(ll.head);

}


// class Solution {
// public:

//     ListNode* reverseList(ListNode* head) {
//         return reverseListInt(head, NULL);
//     }
    
    
//     ListNode* reverseListInt(ListNode* head, ListNode* newHead) {
//         if (head == NULL)
//             return newHead;
//         ListNode* next = head->next;
//         head->next = newHead;
//         return reverseListInt(next, head);
//     }

// };
