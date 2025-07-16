import java.util.*;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bills = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            int kWh = sc.nextInt();
            bills[i] = calc(kWh);
            total += bills[i];
        }

        for (int bill : bills) {
            System.out.println("Bill: $" + bill);
        }
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + Math.round((double) total / n));
        sc.close();
    }

    static int calc(int kWh) {
        int[] limits = {120, 210, 170, 200, 300};
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};
        int cost = 0, i = 0;
        for (; i < limits.length && kWh > 0; i++) {
            int used = Math.min(kWh, limits[i]);
            cost += Math.round(used * rates[i]);
            kWh -= used;
        }
        if (kWh > 0) cost += Math.round(kWh * rates[i]);
        return cost;
    }

   /*
 * Time Complexity: O(n)
 * 說明：
 * - 每筆電量計算一次帳單金額，共 n 筆。
 * - 每次計算最多經過 6 個費率區間，視為常數時間。
 *
 * Space Complexity: O(1)
 * 說明：
 * - 僅使用固定變數累加總費用與平均，不需額外陣列。
 * - 所有處理皆為原地計算。
 */

}
