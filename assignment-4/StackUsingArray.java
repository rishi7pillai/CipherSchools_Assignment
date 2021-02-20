package Stack;

public class StackUsingArray {
    int size;
    int[] array;
    int top;

    StackUsingArray(int size) {
        this.size = size;
        this.array = new int[size];
        this.top = -1;
    }

    public void push(int value) {
        if (!isFull()) {
            top++;
            array[top] = value;
            System.out.println("Pushed element is: " + value);
        } else {
            System.out.println("Stack is full ");
        }
    }

    public void  pop() {
        if (!isEmpty()) {
            int returnedTop = top;
            top--;
            System.out.println("Popped element is: " + array[returnedTop]);
        } else {
            System.out.println("Stack is empty");
        }
    }

    public int peek() {
        if(!this.isEmpty())
            return array[top];
        else
        {
            System.out.println("Stack is Empty");
            return -1;
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (size - 1 == top);
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(10);
        stack.pop();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Value at top is: " + stack.peek());
        stack.pop();
        System.out.println("Value at top is: " + stack.peek());
        stack.pop();
        System.out.println("Value at top is: " + stack.peek());
        stack.pop();
        System.out.println("Value at top is: " + stack.peek());
    }
}
