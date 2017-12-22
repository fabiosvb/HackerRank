package algorithms.strings;

import java.util.Scanner;

public class SuperReducedString {

    static String super_reduced_string(String s){
        StringBuilder builder  = new StringBuilder(s);
        int i = 0;
        boolean again = false;
        while (i < builder.length() - 1){
            if (builder.charAt(i) == builder.charAt(i + 1)){
                builder.deleteCharAt(i);
                builder.deleteCharAt(i);
                again = true;
            }
            i++;
        }
        if (again){
            return super_reduced_string(builder.toString());
        }
        return builder.toString().trim().equals("") ? "Empty String" : builder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
        in.close();
    }
}