public class ArrayStatistics {
    public static void main(String[] args) {
        int[] array = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = 0;
        for (int num : array) {
            sum += num;
        }

        double average = (double) sum / array.length;

        int max = array[0];
        int min = array[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }

        int countAboveAverage = 0;
        for (int num : array) {
            if (num > average) {
                countAboveAverage++;
            }
        }

        int evenCount = 0;
        int oddCount = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("+----------------------+-----------+");
        System.out.printf("| %-20s | %-9s |\n", "統計項目", "結果");
        System.out.println("+----------------------+-----------+");
        System.out.printf("| %-20s | %9d |\n", "總和", sum);
        System.out.printf("| %-20s | %9.2f |\n", "平均值", average);
        System.out.printf("| %-20s | %9d |\n", "最大值", max);
        System.out.printf("| %-20s | %9d |\n", "最大值索引", maxIndex);
        System.out.printf("| %-20s | %9d |\n", "最小值", min);
        System.out.printf("| %-20s | %9d |\n", "最小值索引", minIndex);
        System.out.printf("| %-20s | %9d |\n", "大於平均值數量", countAboveAverage);
        System.out.printf("| %-20s | %9d |\n", "偶數數量", evenCount);
        System.out.printf("| %-20s | %9d |\n", "奇數數量", oddCount);
        System.out.println("+----------------------+-----------+");
    }
}
