public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] c = new int[2][2];

        // 使用三層迴圈計算矩陣乘法，時間複雜度為 O(n³)
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("計算位置 c[" + i + "][" + j + "]：");
                StringBuilder formula = new StringBuilder();
                StringBuilder terms = new StringBuilder();
                for (int k = 0; k < 2; k++) {
                    int mul = a[i][k] * b[k][j];
                    formula.append(a[i][k]).append("*").append(b[k][j]);
                    terms.append(mul);
                    c[i][j] += mul;
                    if (k < 1) {
                        formula.append(" + ");
                        terms.append(" + ");
                    }
                }
                System.out.println(formula + " = " + terms + " = " + c[i][j]);
            }
        }

        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}
