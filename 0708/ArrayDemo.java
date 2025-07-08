
public class ArrayDemo {
   public static void main (String[] args) {
        double[] numbers ={1.11, 2.22, 3.33, 4.44, 5.55};
        //int[] numbers= {1,2,3,4,5};
        for (int i=0; i< numbers.length; i++){
        System.out.println(numbers[i]);
        System.out.println("Index:" +i);
        System.out.println("占用記憶體:" + (Integer.BYTES+"bytes"));

      }
   } 
}
