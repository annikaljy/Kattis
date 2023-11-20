// link to question: https://open.kattis.com/problems/workstations

import java.util.*;
public class workstations {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int res = 0;
        int n = Integer.parseInt(input.next());
        int m = Integer.parseInt(input.next());

        PriorityQueue<Integer[]> allTimes = new PriorityQueue<>(new Sort());
        PriorityQueue<Integer> endTime = new PriorityQueue<>();

        for (int i =0; i<n; i++){
            int start = Integer.parseInt(input.next());
            int time1 = Integer.parseInt(input.next());
            int end = time1 + start;
            allTimes.add(new Integer[] {start, end});
        }

        for (int i =0; i<n; i++){
            Integer[] timings = allTimes.poll(); // look at each set of timings
            endTime.add(timings[1]); // add the end timings to endTimes

            if (timings[0] <endTime.peek()){
                continue;
            }

            while(!endTime.isEmpty()){
                int firstEndTime = endTime.poll();
                int range = timings[0] - firstEndTime;

                if (range < 0){
                    endTime.add(firstEndTime);
                    break;
                }
                else if (range<=m){
                    res++;
                    break;
                }
            }
        }
        System.out.println(res);

    }
}
class Sort implements Comparator<Integer[]> {
    public int compare(Integer[] arr, Integer[] other) {
        if (arr[0] > other[0]) {
            return 1;
        } else if (arr[0] == other[0]) {
            return 0;
        } else {
            return -1;
        }
    }
}
