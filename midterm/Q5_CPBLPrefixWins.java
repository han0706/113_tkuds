import java.util.*;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] games = new int[n];
        for (int i = 0; i < n; i++) {
            games[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] ps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i - 1] + games[i - 1];
        }

        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + ps[i]);
        }
        System.out.println();
        sc.close();
    }

    /*
     * Time Complexity: O(n)
     * 說明：建立 prefix sum 陣列需一次走訪，為 O(n)。
     */
}
