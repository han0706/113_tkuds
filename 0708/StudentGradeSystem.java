public class StudentGradeSystem {
    public static char getGrade(int score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else return 'D';
    }

    public static void printReport(int[] scores) {
        int countA = 0, countB = 0, countC = 0, countD = 0;
        int sum = 0;

        int maxScore = scores[0];
        int minScore = scores[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                maxIndex = i;
            }
            if (scores[i] < minScore) {
                minScore = scores[i];
                minIndex = i;
            }

            char grade = getGrade(scores[i]);
            switch (grade) {
                case 'A': countA++; break;
                case 'B': countB++; break;
                case 'C': countC++; break;
                case 'D': countD++; break;
            }
        }

        double average = (double) sum / scores.length;

        int countAboveAvg = 0;
        for (int score : scores) {
            if (score > average) {
                countAboveAvg++;
            }
        }
        double proportionAboveAvg = (double) countAboveAvg / scores.length * 100;

        System.out.println("學生分數等級報告");
        System.out.println("========================================");
        System.out.printf("總學生數: %d\n", scores.length);
        System.out.printf("最高分: %d (學生編號 %d)\n", maxScore, maxIndex);
        System.out.printf("最低分: %d (學生編號 %d)\n", minScore, minIndex);
        System.out.printf("平均分數: %.2f\n", average);
        System.out.printf("高於平均分學生比例: %.2f%%\n", proportionAboveAvg);
        System.out.println("----------------------------------------");
        System.out.printf("等級統計：A:%d  B:%d  C:%d  D:%d\n", countA, countB, countC, countD);
        System.out.println("----------------------------------------");
        System.out.println("學生編號  分數  等級");
        System.out.println("----------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%6d  %4d  %2c\n", i, scores[i], getGrade(scores[i]));
        }
    }

    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        printReport(scores);
    }
}
