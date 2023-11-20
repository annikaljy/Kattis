// link to the question: https://open.kattis.com/problems/apaxiaaans

import java.util.*;

public class apaxiaaans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String name = "";
        name += input.charAt(0);
        
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(i-1))
                name += input.charAt(i);
        }
        
        System.out.println(name);
    }
}
