package LinkedList;

public class SinglyLinkedList {
    Node head;
    public static class Node {

        public int data;

        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printList(SinglyLinkedList list) {
        Node current = list.head;

        while(current != null) {
            System.out.print(current.data + "  ->  ");
            current = current.next;
        }
        System.out.println();
    }

    public static SinglyLinkedList insert(SinglyLinkedList list,int data)
    {
        Node node =new Node(data);
        if(list.head == null){
            list.head =node;
        }
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next =node;
        }
        return list;
    }

    public static SinglyLinkedList deleteWithKey(SinglyLinkedList list, int key)
    {
        Node currNode = list.head, prev = null;

        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;
            System.out.println(key + " deleted");
            return list;
        }
        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }
        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(key + " deleted");
        }
        if (currNode == null) {
            System.out.println(key + " not found");
        }
        return list;
    }

    public static SinglyLinkedList deleteWithPos(SinglyLinkedList list, int index)
    {
        Node currNode = list.head, prev = null;

        if (index == 0 && currNode != null) {
            list.head = currNode.next;
            System.out.println(index + " pos element deleted");
            return list;
        }

        int counter = 0;
        while (currNode != null) {

            if (counter == index) {
                prev.next = currNode.next;

                System.out.println(index + " pos element deleted");
                break;
            }
            else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }
        if (currNode == null) {
            System.out.println(index + " pos element not found");
        }
        return list;
    }

    public static void main(String[] args) {
        SinglyLinkedList SList =new SinglyLinkedList();

        //Insertions
        insert(SList, 10);
        insert(SList, 20);
        insert(SList, 30);
        insert(SList, 40);
        insert(SList, 50);
        printList(SList); //Printing

        //deletions with key
        deleteWithKey(SList, 20);
        printList(SList); //printing
        deleteWithKey(SList, 30);
        printList(SList); //printing
        deleteWithKey(SList, 5);
        printList(SList);

        //deletions with index
        deleteWithPos(SList,1);
        printList(SList);
        deleteWithPos(SList,0);
        printList(SList);
        deleteWithKey(SList,8);
        printList(SList);

    }
    }
