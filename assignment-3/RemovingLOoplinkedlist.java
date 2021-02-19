package LinkedList;

public class RemovingLoopInLinkedList {

    public static void findAndRemoveLoop(Node head)
    {
        Node slow = head;
        Node fast = head;
        boolean isloop =false;

        while(slow!=null && fast!=null && fast.next!=null) {
            slow =slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                isloop = true;
                break;
            }
        }

        if(isloop){
            slow =head;
            Node prev = null;
            while (slow != fast) {
                prev = fast;
                fast = fast.next;
                slow = slow.next;
            }
            System.out.println("Loop Found at: " + slow.data);
            prev.next = null;
            System.out.println("Loop removed ");
            Node.printList(head);
        }
        else
            System.out.println("No loop found");

    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        //Creating loop
        head.next.next.next.next.next = head.next.next;

        findAndRemoveLoop(head);
    }


}
