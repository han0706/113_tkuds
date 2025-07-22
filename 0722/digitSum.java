public class digitSum {
    public static int digitSum(int n) {
        if (n < 10) {
            return n;
        }
        return (n % 10) + digitSum(n / 10);
    }

    public static void main(String[] args) {
        int number = 12345;
        System.out.println(digitSum(number)); // 輸出 15
    }
}
