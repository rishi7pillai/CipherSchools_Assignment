package Assignment3;

class ReverseLinkedList1 {

    /* Function to reverse the linked list */
    static Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
   //Function to reverse by recursion
    static Node reverseRecursive(Node head)
    {
        if (head == null || head.next == null)
            return head;

        Node rest = reverse(head.next);
        head.next.next = head;

        head.next = null;

        return rest;
    }

    // prints content of double linked list
    static void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Given Linked list");
        printList(head);
        //iterative call
        head = reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        printList(head);
        //recursion call
        head = reverseRecursive(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        printList(head);
    }
}
