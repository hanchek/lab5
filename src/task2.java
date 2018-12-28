import java.util.ArrayList;
import java.util.Collections;
public class task2 {
    public static void main(String args[]) {
        ArrayList<Integer> A = new ArrayList<>();
        for(int i = 0; i < 150; i++) {
            int n = (int)(Math.random()*200) + 1;
            A.add(n);
        }
        ArrayList<Integer> B = new ArrayList();
        for(Integer n: A) {
            B.add(n);
        }
        B.sort(Collections.reverseOrder());
        for (int i = 0; i < A.size() - 15; i++) B.remove(B.size()-1);
        System.out.println(A);
        //A.sort(Collections.reverseOrder());
        //System.out.println(A);
        System.out.println(B);
    }
}
