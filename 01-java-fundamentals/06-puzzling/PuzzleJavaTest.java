import java.util.ArrayList;
public class PuzzleJavaTest {
    public static void main(String[] args){
        PuzzleJava puzzle = new PuzzleJava();
        int[] arr = puzzle.getTenRolls();
        //for (int num: arr){
        //    System.out.println(num);
        //}
        
        //System.out.println(puzzle.getRandomLetter());
        //System.out.println(puzzle.generatePassword());
        ArrayList<String> list = puzzle.getNewPasswordSet(4);
        for (String pass: list){
            System.out.println(pass);
        }
    }
}
