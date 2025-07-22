public class fibonacciSlow {

    // 標準遞迴版本 - 效率很差
    // 時間複雜度：O(2^n)
    // 空間複雜度：O(n)
    public static int fibonacciSlow(int n) {
        if (n <= 1) return n;
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }

    // 記憶化版本 - 效率很好
    // 時間複雜度：O(n)
    // 空間複雜度：O(n)
    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 30;

        System.out.println(fibonacciSlow(n));
        int[] memo = new int[n + 1];
        System.out.println(fibonacciFast(n, memo));
    }
}
