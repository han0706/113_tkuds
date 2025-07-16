import java.util.*;

public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) {
                    maxIdx = j;
                }
            }
            double temp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = temp;
        }

        for (int i = 0; i < Math.min(5, n); i++) {
            System.out.printf("%.1f\n", scores[i]);
        }
        sc.close();
    }

    /*
     * Time Complexity: O(n^2)
     * 說明：選擇排序需進行 n(n-1)/2 次比較，因此為 O(n²)。
     */
}
/*
 * Time Complexity: O(n²)
 * 說明：
 * - 使用選擇排序將 n 個評分由高到低排序。
 * - 外層 n 次，內層比較最多 n-1 次，共需約 n(n-1)/2 次比較。
 *
 * Space Complexity: O(1)
 * 說明：
 * - 使用原地排序，未使用額外陣列。
 * - 僅使用數個變數儲存最大值與索引。
 */
