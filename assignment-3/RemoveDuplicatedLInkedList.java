package LinkedList;

public class RemoveDuplicatedLinkedList {
    static Node headptr = null;
    public static void removeDuplicates() {
        Node temp = new Node(0);
        temp.next = headptr;
        Node prev = temp;
        Node current = headptr;

        while (current != null) {
            while (current.next != null && prev.next.data == current.next.data)
                current = current.next;

            if (prev.next == current)
                prev = prev.next;
            else
                prev.next = current.next;
            current = current.next;
        }
        headptr = temp.next;
    }

    public static void main(String []args){
        Node head = new Node(10);
        head.next = new Node(15);
        head.next.next = new Node(15);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(30);
        head.next.next.next.next.next = new Node(30);

        headptr =head;

        System.out.println("Linked list is: ");
        Node.printList(headptr);

        removeDuplicates();

        System.out.println("After removing duplicates: ");
        Node.printList(headptr);
    }

}
