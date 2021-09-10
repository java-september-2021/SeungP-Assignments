import java.util.ArrayList;
public class BasicJavaTest {
    public static void main(String[] args){
        BasicJava java = new BasicJava();
        //java.printOdds();
        //int sum = java.sigmaSum();
        //System.out.println(sum);

        int[] arr = {-1,-3,-15,-7,-9,-11,-3};
        //java.printArray(arr);
        java.printMax(arr);

        ArrayList<Integer> arrList = java.oddArray();
        System.out.println(arrList);
    }
}
