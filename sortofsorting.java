// link to question: https://open.kattis.com/problems/sortofsorting

import java.util.*;

public class sortofsorting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            int number = input.nextInt();
            if (number != 0) {
            ArrayList<String> names = new ArrayList<String>();
            for (int i = 0; i < number; i++) {
                names.add(input.next());
            }
            Collections.sort(names, Comparator.comparing(o -> o.substring(0, 2)));

            for (int j =0; j<names.size(); j++){
                System.out.println(names.get(j));
            }
            System.out.println("");

            }
            if (number ==0) {break;}
        }
    }}
class Compare implements Comparator<String>{
    public int compare(String first, String second){
        return (first.substring(0,2)).compareTo(second.substring(0,2));
    }
}
