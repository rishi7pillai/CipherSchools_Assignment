package Assignment3;

public class MergeTwoList {
    public static Node sortedMerge(Node headA, Node headB)
    {

        if(headA == null) return headB;
        if(headB == null) return headA;

        if(headA.data < headB.data)
        {
            headA.next = sortedMerge(headA.next, headB);
            return headA;
        }
        else
        {
            headB.next = sortedMerge(headA, headB.next);
            return headB;
        }

    }

    static void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String args[])
    {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);

        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);

        Node newHead = sortedMerge(head,head2);

        printList(newHead);


    }
}
