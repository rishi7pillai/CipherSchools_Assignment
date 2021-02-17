import java.io.*;
import java.util.Scanner;

class SpiralMatrix {

    static void spiralPrint(int m, int n, int a[][])
    {
        int i, k = 0, l = 0;


        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                System.out.print(a[k][i] + " ");
            }
            k++;

            // Print the last column from the remaining
            // columns
            for (i = k; i < m; ++i) {
                System.out.print(a[i][n - 1] + " ");
            }
            n--;

            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(a[m - 1][i] + " ");
                }
                m--;
            }

            // Print the first column from the remaining
            // columns
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int r = sc.nextInt();
        System.out.println("Enter number of cols");
        int c = sc.nextInt();
        int [][] matrix = new int[r][c];

        for(int i = 0; i < r; i++) {
            System.out.println("Enter elements for row" + i);
            for(int j = 0; j  < c; j++) {
                int element = sc.nextInt();
                matrix[i][j] = element;
            }
        }
        spiralPrint(r, c, matrix);
    }
}
