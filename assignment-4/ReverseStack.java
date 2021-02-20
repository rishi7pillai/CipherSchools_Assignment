package Stack;

import java.util.Stack;

class ReverseStack {
    static Stack<Integer> stack = new Stack<>();

    static void pushAtBottom(int x)
    {
        if(stack.isEmpty())
            stack.push(x);
        else
        {
            int a = stack.peek();
            stack.pop();
            pushAtBottom(x);
            stack.push(a);
        }
    }
    static void reverse()
    {
        if(stack.size() > 0)
        {
            int x = stack.peek();
            stack.pop();
            reverse();
            pushAtBottom(x);
        }
    }

    public static void main(String[] args)
    {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Stack is: ");

        System.out.println(stack);

        reverse();

        System.out.println("Stack are reversing: ");

        System.out.println(stack);
    }
}
