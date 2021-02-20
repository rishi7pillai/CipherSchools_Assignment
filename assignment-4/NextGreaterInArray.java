package Stack;

import java.util.Stack;

public class NextGreaterInArray {

    public static void getNextGreaterElement(int[] arr, int n)
    {
        Stack<Integer> s = new Stack<>();
        int element, next;

        s.push(arr[0]);

        for (int i = 1; i < n; i++)
        {
            next = arr[i];
            if (!s.isEmpty())
            {
                element = s.pop();
                while (element < next)
                {
                    System.out.println(element + " -> "+ next);
                    if (s.isEmpty())
                        break;
                    element = s.pop();
                }
                if (element > next)
                    s.push(element);
            }
            s.push(next);
        }
        while (!s.isEmpty())
        {
            element = s.pop();
            next = -1;
            System.out.println(element + " -> " + next);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 11, 13, 21, 3 };
        int n = arr.length;
        getNextGreaterElement(arr, n);
    }
}
