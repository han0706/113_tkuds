import java.util.Scanner;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            String[] time = sc.next().split(":");
            times[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }
        String[] query = sc.next().split(":");
        int queryMin = Integer.parseInt(query[0]) * 60 + Integer.parseInt(query[1]);
        
        int left = 0, right = n - 1, idx = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > queryMin) {
                idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (idx == n) {
            System.out.println("No train");
        } else {
            System.out.printf("%02d:%02d\n", times[idx] / 60, times[idx] % 60);
        }
        sc.close();
    }

   

}
 /*
 * Time Complexity: O(n + log n)
 * 說明：
 * - O(n)：將 n 組時間字串轉換為分鐘數。
 * - O(log n)：使用二分搜尋找出下一班比 query 大的時間。
 * - 總體為 O(n + log n)，但主要由 O(n) 主導。
 *
 * Space Complexity: O(n)
 * 說明：
 * - 使用一個 int 陣列儲存 n 個分鐘數。
 * - 其他變數為常數空間。
 */