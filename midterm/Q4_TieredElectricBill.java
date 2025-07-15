import java.util.Scanner;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] kWh = new int[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            kWh[i] = sc.nextInt();
            long bill = calc(kWh[i]);
            System.out.printf("Bill: $%d\n", bill);
            total += bill;
        }
        System.out.printf("Total: $%d\n", total);
        System.out.printf("Average: $%d\n", Math.round((double) total / n));
        
        sc.close();
    }
    
    static long calc(int k) {
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};
        int[] limits = {120, 330, 500, 700, 1000, Integer.MAX_VALUE};
        double cost = 0;
        int remaining = k;
        for (int i = 0; i < limits.length; i++) {
            int consume = Math.min(remaining, limits[i] - (i == 0 ? 0 : limits[i - 1]));
            if (consume <= 0) break;
            cost += consume * rates[i];
            remaining -= consume;
        }
        return Math.round(cost);
    }
    
    /*
     * Time Complexity: O(n)
     * 說明：每個 kWh 計算為 O(1)（固定 6 段），總共 n 次計算。
     */
}