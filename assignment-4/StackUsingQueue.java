package Stack;

import java.util.LinkedList;
import java.util.Queue;


class StackUsingQueue {
    
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int stackSize;
    
    public StackUsingQueue()
    {
        stackSize = 0;
    }

    void remove()
    {
        if (q1.isEmpty())
            return;
        
        while (q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }
        q1.remove();
        stackSize --;
        
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    void add(int x)
    {
        q1.add(x);
        stackSize++;
    }

    int top()
    {
        if (q1.isEmpty())
            return -1;

        while (q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }
        int temp = q1.peek();

        q1.remove();

        q2.add(temp);

        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return temp;
    }

    int size()
    {
        return stackSize;
    }
    
    public static void main(String[] args)
    {
        StackUsingQueue s = new StackUsingQueue();
        s.add(11);
        s.add(22);
        s.add(33);
        s.add(44);

        System.out.println("Current size of Stack: " + s.size());
        System.out.println("Element on top of Stack: " + s.top());

        s.remove();
        System.out.println("Element on top of Stack: " + s.top());

        s.remove();
        System.out.println("Element on top of Stack: " + s.top());
        System.out.println("Current size of Stack: " + s.size());
    }
}
