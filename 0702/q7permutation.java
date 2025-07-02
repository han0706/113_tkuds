import java.util.Scanner;

public class q7permutation {
    static int ops = 0;

    public static void permute(int[] arr, int l, int r) {
        if (l == r) {
            for (int i = 0; i <= r; i++) {
                System.out.print(arr[i] + (i < r ? " " : ""));
            }
            System.out.println();
            ops++;
            return;
        }

        for (int i = l; i <= r; i++) {
            swap(arr, l, i);
            permute(arr, l + 1, r);
            swap(arr, l, i); // backtrack
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = i + 1;

        permute(arr, 0, n - 1);

        System.out.println(ops);
    }
}
