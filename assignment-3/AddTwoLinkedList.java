package LinkedList;

public class AddTwoNumbersLinkedList {

    public static Node sum(Node head1, Node head2) {

        Node sum = null;
        if(Node.size(head1) > Node.size(head2)) {
            int diff = Node.size(head1) - Node.size(head2);
            sum = Helper(head1, head2, diff);
        } else {
            int diff = Node.size(head2) - Node.size(head1);
            sum = Helper(head2, head1, diff);
        }

        Node temp = new Node(1);

        if(sum.data > 9) {
            sum.data = sum.data % 10;
            temp.next = sum;
            sum = temp;
        }
        return sum;
    }

    public static Node Helper(Node head1, Node head2, int difference) {

        if(head1 == null) {
            return null;
        }

        Node result = null;
        if(difference== 0) {
            result = new Node(head1.data + head2.data);
        } else {
            result = new Node(head1.data);
        }

        Node recursiveResult = null;
        if(difference == 0) {
            recursiveResult  = Helper(head1.next, head2.next, difference);
        } else {
            recursiveResult  = Helper(head1.next, head2,difference- 1);
        }


        if(recursiveResult != null && recursiveResult.data > 9) {
            recursiveResult.data = recursiveResult.data % 10;
            result.data = result.data + 1;
        }

        result.next = recursiveResult;
        return result;
    }
    public static void main(String[] args) {
        Node head1 = new Node(4);
        head1.next = new Node(5);
        head1.next.next = new Node(6);
        System.out.println("List 1 :");
        Node.printList(head1);

        Node head2 =new Node(7);
        head2.next = new Node(8);
        head2.next.next = new Node(9);
        System.out.println("List 2 :");
        Node.printList(head2);

        Node sum = sum(head1 , head2);
        System.out.println("Sum :");
        Node.printList(sum);
    }
}
