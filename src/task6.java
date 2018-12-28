public class task6 {
    public static String reverseString(String s) {
        char[] temp = s.toCharArray();
        for(int i = 0; i < temp.length/2; i++) {
           char t = temp[i];
           temp[i] = temp[temp.length - i - 1];
           temp[temp.length - i - 1] = t;
        }
        return new String(temp);
    }

    public static void main(String args[]) {
        String s = "This is a string.";
        System.out.println(reverseString(s));
    }
}
