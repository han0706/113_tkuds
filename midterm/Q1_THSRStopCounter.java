import java.util.*;

public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stops = new String[n];
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }
        String start = sc.next();
        String end = sc.next();
        
        int startIdx = -1, endIdx = -1;
        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) startIdx = i;
            if (stops[i].equals(end)) endIdx = i;
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(startIdx - endIdx) + 1);
        }
        sc.close();
    }

 }
/*
 * Time Complexity: O(n)
 * 說明：
 * - 使用一個 for 迴圈走訪 n 個站名以找出起訖站索引。
 * - 每個元素最多檢查一次，因此是線性時間。
 *
 * Space Complexity: O(n)
 * 說明：
 * - 使用 String 陣列儲存 n 個站名。
 * - 其他變數為常數空間。
 */
