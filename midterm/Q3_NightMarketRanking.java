import java.util.Scanner;

public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }
        
        for (int i = 0; i < Math.min(n, 5); i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) {
                    maxIdx = j;
                }
            }
            double temp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = temp;
            System.out.printf("%.1f\n", scores[i]);
        }
        
        sc.close();
    }
    
    /*
     * Time Complexity: O(n²)
     * 說明：選擇排序每次尋找最大值，內外迴圈導致比較次數為 n(n-1)/2。
     */
}