// link to question: https://open.kattis.com/problems/autori

import java.util.*;

public class autori{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String ans = "";
        
        String[] items = str.split("-");
        for (int i = 0; i < items.length; i++){
            ans += items[i].charAt(0);
        }
        System.out.println(ans);
    }
}
