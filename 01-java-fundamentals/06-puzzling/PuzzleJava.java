import java.util.Random;
import java.util.ArrayList;
public class PuzzleJava {
    Random rand = new Random();

    public int[] getTenRolls(){
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt(20) + 1;
        }
        return arr;
    }

    public String getRandomLetter(){
        String[] arr = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        return arr[rand.nextInt(25)];
    }

    public String generatePassword(){
        String pass = "";
        for (int i = 0; i < 8; i++){
            pass = pass + getRandomLetter();
        }
        return pass;
    }

    public ArrayList<String> getNewPasswordSet(int length){
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < length; i++){
            list.add(generatePassword());
        }
        return list;
    }
}
