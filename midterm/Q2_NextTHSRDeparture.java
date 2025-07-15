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

    /*
     * Time Complexity: O(log n)
     * 說明：將時間轉為分鐘數為 O(n)，二分搜尋找下一班次為 O(log n)，總複雜度以 O(log n) 主導。
     */
}
