// link to question: https://open.kattis.com/problems/detaileddifferences

import java.util.*;

public class detaileddifferences {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int no = input.nextInt();
        StringBuilder res = new StringBuilder();
        
        for (int i = 1; i <=no; i++){
            String d1 = input.next();
            String d2 = input.next();
            
            for (int j = 0; j <= d1.length(); j++){
                if (d1.charAt(j)== d2.charAt(j)){
                    res.append('.');
                } else {res.append('*');
                  }
            }
            System.out.println(d1);
            System.out.println(d2);
            System.out.println(res);
            }
        }
}
