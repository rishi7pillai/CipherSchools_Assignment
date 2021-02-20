package Stack;

import java.util.ListIterator;
import java.util.Stack;

class SortStack
{
    static void sortedInsert(Stack<Integer> s, int x)
    {
        if (s.isEmpty() || x > s.peek())
        {
            s.push(x);
            return;
        }
        int temp = s.pop();
        sortedInsert(s, x);
        s.push(temp);
    }
    static void sort(Stack<Integer> s)
    {
        if (!s.isEmpty())
        {
            int x = s.pop();
            sort(s);
            sortedInsert(s, x);
        }
    }

    static void printStack(Stack<Integer> s)
    {
        ListIterator<Integer> lt = s.listIterator();
        while (lt.hasNext())
            lt.next();
        while (lt.hasPrevious())
            System.out.print(lt.previous() + " ");
    }

    public static void main(String[] args)
    {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(5);
        s.push(23);
        s.push(-15);
        s.push(-4);

        System.out.println("Stack elements are: ");
        printStack(s);

        sort(s);

        System.out.println("\nStack elements after sorting are: ");
        printStack(s);
    }
}
