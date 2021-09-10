import java.util.ArrayList;
public class BasicJava {
    public void printNumbers(){
        for (int i = 1; i <= 255; i++){
            System.out.println(i);
        }
    }

    public void printOdds(){
        for (int i = 1; i <= 255; i++){
            if (i % 2 != 0){
                System.out.println(i);
            }
            
        }
    }

    public int sigmaSum(){
        int sum = 0;
        for (int i = 0; i < 255; i++){
            sum += i;
        }
        return sum;
    }

    public void printArray(int[] arr){
        for (int num:arr){
            System.out.println(num);
        }
    }

    public void printMax(int[] arr){
        int max = arr[1];
        for (int num:arr){
            if (num > max){
                max = num;
            }
        }
        System.out.println(max);
    }

    public ArrayList<Integer> oddArray(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i <= 255; i++){
            if (i % 2 == 1){
                arr.add(i);
            }
        }
        return arr;
    }
}
