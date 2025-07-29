import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<String> stops = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stops.add(sc.next()); 
        }

        String start = sc.next();
        String end = sc.next();

        int idx1 = stops.indexOf(start);
        int idx2 = stops.indexOf(end);

        if (idx1 == -1 || idx2 == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(idx1 - idx2) + 1);
        }

        sc.close();
    }
}
/*
 * Time Complexity: O(n)
 * 說明：stops.indexOf() 在最壞情況下會遍歷整個 List，各執行一次為 O(n) + O(n) = O(n)。
 * 其他操作如輸入、比較、加減法皆為 O(1)。
 */
