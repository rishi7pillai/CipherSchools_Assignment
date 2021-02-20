package Stack;

class MinStack {
    private Node head;

    public void push(int x) {
        if(head == null)
            head = new Node(x, x);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private static class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(10);
        obj.push(5);
        obj.push(1);
        obj.push(11);
        obj.push(13);

        obj.pop();
        int topEle = obj.top();
        System.out.println("Element at top: "+ topEle);
        int minEle = obj.getMin();
        System.out.println("Min element: "+ minEle);
    }
}
