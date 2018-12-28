import java.util.*;
import java.util.Scanner;

public class task4 {
    public static void main(String args[]) {
        Random random = new Random();
        int n = random.nextInt(100);
        System.out.println(n);
        Scanner in = new Scanner(System.in);
        int left = 0;
        int right = 100;
        System.out.println("Lets start a game!\n\n");
        int Input = 0;
        do {
            boolean flag = true;
            while(flag) {
                System.out.println("Input number in range:" + left + "-" + right);
                while(!in.hasNextInt()) {
                    System.out.println("That's not a number!");
                    in.next();
                }
                Input = in.nextInt();
                if(Input < left || Input > right){
                    System.out.println("Your number is out of bounds!");
                } else flag = false;
            }
            if(Input == n) {
                System.out.println("You won");
            } else if( Input > n) right = Input;
            else left = Input;
        }while(Input != n);
    }
}
