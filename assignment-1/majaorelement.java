import java.util.Scanner;

public class MajorityEle {
    static void isMajority(int arr[]){
        int maxOccur = 0;
        int index = -1; // sentinels
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    count++;
            }

            if (count > maxOccur) {
                maxOccur = count;
                index = i;
            }
        }

        if (maxOccur > arr.length / 2)
            System.out.println(arr[index]);

        else
            System.out.println("No Majority Element");
    }

    public static void main(String[] args) {
        System.out.println("Enter Size");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        System.out.println("Enter the array element");
        for(int i =0; i < n; i++)
        {
            arr[i]=sc.nextInt();
        }

        isMajority(arr);
    }
}
