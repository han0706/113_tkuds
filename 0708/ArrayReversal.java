import java.util.Arrays;

class ArrayReversal {

    // 方法一：原地反轉（直接修改原陣列）
    static void reverseInPlace(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    // 方法二：建立新陣列（保留原本不變）
    static int[] reverseToNew(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int[] copy = numbers.clone();  // 備份原始陣列

        System.out.println("原始陣列：" + Arrays.toString(numbers));

        // 原地反轉
        reverseInPlace(numbers);
        System.out.println("原地反轉後：" + Arrays.toString(numbers));

        // 使用新陣列反轉（不改原本）
        int[] newReversed = reverseToNew(copy);
        System.out.println("新反轉陣列：" + Arrays.toString(newReversed));
    }
}
