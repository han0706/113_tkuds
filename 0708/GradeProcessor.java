public class GradeProcessor {
    
    
    public static void main(String[] args) {
        int[] grades = {78, 85, 92, 67, 88, 95, 73, 90};

        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }

        double average = (double) sum / grades.length;

        int max = grades[0];
        int min = grades[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
                maxIndex = i;
            }
            if (grades[i] < min) {
                min = grades[i];
                minIndex = i;
            }
        }

        int countAboveAverage = 0;
        for (int grade : grades) {
            if (grade > average) {
                countAboveAverage++;
            }
        }

        System.out.println("總分: " + sum);
        System.out.printf("平均分數: %.2f\n", average);
        System.out.println("最高分: " + max + " (索引位置: " + maxIndex + ")");
        System.out.println("最低分: " + min + " (索引位置: " + minIndex + ")");
        System.out.println("超過平均分數的人數: " + countAboveAverage);
        System.out.println("所有成績如下:");

        for (int i = 0; i < grades.length; i++) {
            System.out.println("學生編號 " + i + ": " + grades[i]);
        }
    }
}


