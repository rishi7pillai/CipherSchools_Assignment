package Stack;

import java.util.Stack;

public class LargestHistogram {

    public static int maxAreaInHistogram(int [] hist) {
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        int i = 0;
        while(i < hist.length) {
            int currentBuilding = hist[i];
            if(stack.isEmpty() || currentBuilding >= hist[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int previousBar = stack.pop();
                int height = hist[previousBar];
                int width;
                if(stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                int area = height * width;
                maxArea = Math.max(area, maxArea);
            }
        }

        while(!stack.isEmpty()) {
            int previousBar = stack.pop();
            int height = hist[previousBar];
            int width;
            if(stack.isEmpty()) {
                width = i;
            } else {
                width = i - stack.peek() - 1;
            }
            int area = height * width;
            maxArea = Math.max(area, maxArea);
        }

        return  maxArea;
    }


    public static void main(String[] args) {

        int [] hist = {6, 1, 5, 4, 5, 2, 6};

        System.out.println(maxAreaInHistogram(hist));
    }
}
