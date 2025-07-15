import java.util.Scanner;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] games = new int[n];
        for (int i = 0; i < n; i++) {
            games[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + games[i - 1];
        }
        
        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + prefixSum[i]);
        }
        
        sc.close();
    }
    
    /*
     * Time Complexity: O(n)
     * 說明：建前綴和陣列需 O(n)，查詢 k 個結果為 O(k)，總複雜度為 O(n)。
     */
}