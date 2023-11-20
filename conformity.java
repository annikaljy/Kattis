// link to question: https://open.kattis.com/problems/conformity

import java.util.*;
public class conformity {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int currentMax = 0;
        int total = 0;
        String S;
        HashMap<String, Integer> H = new HashMap<String, Integer>();

        for (int i=0; i<n; i++) {
            String[] arr = new String[5];
            for (int j = 0; j < 5; j++) {
                arr[j] = String.valueOf(((input.nextInt())));
            }
            Arrays.sort(arr);
            S = "";

            for (int k = 0; k < 5; k++) {
                Integer number = Integer.valueOf(arr[k]);
                if (number != null) {
                    S += Integer.toString(number);
                } else {
                    S = "";
                }
            }

            if (H.containsKey(S)) {
                H.put(S, H.get(S)+1);
            } else {
                H.put(S, 1);
            }
            if (H.get(S) > currentMax) {
                currentMax = H.get(S);
            }
        }

        for (Map.Entry<String, Integer> entry : H.entrySet()) {
            if (entry.getValue() == currentMax) {
                total += entry.getValue();
            }
        }

        System.out.println(total);
        }

}
