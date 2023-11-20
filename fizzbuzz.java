// link to question: https://open.kattis.com/problems/fizzbuzz

import java.util.*;

public class fizzbuzz {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int X = input.nextInt();
        int Y = input.nextInt();
        int N = input.nextInt();

        for (int i=1; i<=N; i++){
            if (i % X == 0 && i %Y==0){
                System.out.println("FizzBuzz");
            }
            else if (i % X == 0){
                System.out.println("Fizz");
            }
            else if (i % Y == 0){
                System.out.println("Buzz");
            }
            else{System.out.println(i);}
        }
    }
}