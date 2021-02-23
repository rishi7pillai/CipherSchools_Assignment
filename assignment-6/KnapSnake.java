import java.util.Arrays;

public class KnapSack {
    public  static int knapsackMemoization(int [] wts, int [] vals, int  N, int W, int [][] dp)
    {
        if (N == 0 || W == 0) {
            return 0;
        }

        if(dp[N][W] != -1) {
            return dp[N][W];
        }

        if (wts[N - 1] <= W) {
            int remainingCapacity = W - wts[N - 1];
            int considerItem =   vals[N - 1] + knapsackMemoization(wts, vals, N - 1, remainingCapacity, dp);
            int notConsiderItem = knapsackMemoization(wts, vals, N - 1, W, dp);
            dp[N][W] = Math.max(considerItem, notConsiderItem);
        }
        else{
            int notConsiderItem = knapsackMemoization(wts, vals, N - 1, W, dp);
            dp[N][W] = notConsiderItem;
        }

        return dp[N][W];
    }


    public static void main(String[] args) {

        int[] val = { 60, 100, 120 };
        int[] wt = { 10, 20, 30 };
        int W = 50;

        int [][] dp = new int[val.length + 1] [W + 1];

        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        System.out.println(knapsackMemoization(wt, val, val.length, W, dp));
    }

}
