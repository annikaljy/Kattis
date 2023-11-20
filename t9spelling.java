// link to question: https://open.kattis.com/problems/t9spelling

import java.util.*;
public class t9spelling {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        HashMap<Character, Integer> alphabets = new HashMap<>();
        alphabets.put('a', 2);
        alphabets.put('b', 22);
        alphabets.put('c', 222);
        alphabets.put('d', 3);
        alphabets.put('e', 33);
        alphabets.put('f', 333);
        alphabets.put('g', 4);
        alphabets.put('h', 44);
        alphabets.put('i', 444);
        alphabets.put('j', 5);
        alphabets.put('k', 55);
        alphabets.put('l', 555);
        alphabets.put('m', 6);
        alphabets.put('n', 66);
        alphabets.put('o', 666);
        alphabets.put('p', 7);
        alphabets.put('q', 77);
        alphabets.put('r', 777);
        alphabets.put('s', 7777);
        alphabets.put('t', 8);
        alphabets.put('u', 88);
        alphabets.put('v', 888);
        alphabets.put('w', 9);
        alphabets.put('x', 99);
        alphabets.put('y', 999);
        alphabets.put('z', 9999);
        alphabets.put(' ', 0);

        input.nextLine();
        for (int i = 1; i <= testCases; i++) { //loop for each test case
            StringBuilder result = new StringBuilder();
            String word = input.nextLine();
            for (int j = 0; j < word.length(); j++) { //loop within the test case
                if (result.length() == 0) {
                    result.append(alphabets.get(word.charAt(j)));
                } else if (result.length() != 0) {
                    if ((alphabets.get(word.charAt(j)))%10 == (alphabets.get(word.charAt(j-1)))%10){
                        result.append(" ");
                        result.append(alphabets.get(word.charAt(j)));
                }
                    else {
                    result.append(alphabets.get(word.charAt(j)));
                }
            }

        }
        System.out.println("Case #" + i + ": " + result);


    }


    }
}
