import java.util.*;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = findGCD(a, b);
        long lcm = (long) a * b / gcd;
        System.out.println("LCM: " + lcm);

        sc.close();
    }

    private static int findGCD(int a, int b) {
        if (a == b) {
            return a;
        } else if (a > b) {
            return findGCD(a - b, b);
        } else {
            return findGCD(a, b - a);
        }
    }
}

/*
 * Time Complexity: O(max(a, b))
 * 說明：
 *  findGCD(a, b) 採用「輾轉相減法」(Subtraction-based Euclidean Algorithm)，
 * 最差情況下每次遞迴只減 1，最多需要 max(a, b) 次遞迴。
 * 主程式中其餘部分皆為常數操作 O(1)。
 * 因此整體時間複雜度為 O(max(a, b))。
 */
