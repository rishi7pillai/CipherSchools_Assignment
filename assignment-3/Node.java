package LinkedList;

public class Node {

    public int data;

    public Node next;

    public Node(int data) {
        this.data = data;
        this.next =null;
    }
    public static void printList(Node head) {
        Node current = head;

        while(current != null) {
            System.out.print(current.data + "  ->  ");
            current = current.next;
        }
        System.out.println();
    }
    public static int size(Node head) {

        int length = 0;
        Node current = head;

        while(current != null) {
            length++;
            current = current.next;
        }
        return  length;
    }
}
