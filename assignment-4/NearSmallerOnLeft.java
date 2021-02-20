package Stack;

import java.util.Stack;

public class NearestSmallerOnLeft {

    static void printNearestSmaller(int[] arr, int n)
    {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.empty()) {
                System.out.print("_, ");
            } else
            {
                System.out.print(stack.peek() + ", ");
            }
            stack.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 10, 2, 5};
        int n = arr.length;
        printNearestSmaller(arr, n);
    }
}
