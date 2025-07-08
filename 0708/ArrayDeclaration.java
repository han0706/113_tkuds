
class ArrayDeclaration {
    public static void main(String[] args) {
        //方法一
        int[] score;   //宣告一個整數陣列參考變數
        score= new int[5]; //在堆積記憶體中分配5個整數空間
        //方法二
        int[] grades =new int[5];//所有元素自動初始化為0

        //方法三
        int[] numbers= {85,92,77,60,88}; //編譯器自動計算陣列大小

        //方法四 動態初始化的另一種寫法
        int[] values =new int[]{10,20,30,40,50};

        System.out.println("個陣列的長度");
        System.out.println("scores"+score.length);
        System.out.println("grades:"+grades.length);
        System.out.println("grades:"+numbers.length);
        System.out.println("values:"+values.length);

    }
}
