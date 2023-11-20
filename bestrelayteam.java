// link to question: https://open.kattis.com/problems/bestrelayteam

import java.util.*;

public class bestrelayteam {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); //number of runners
        List<String> runners = new ArrayList<String>();
        HashMap<String, Double> timeLeg1 = new HashMap<String, Double>();
        HashMap<String, Double> timeLeg2 = new HashMap<String, Double>();
        double bestTime = 100; //safe number as bound for best time

        //add names and their corresponding times into list and hashmaps
        for (int i = 0; i < n; i++) {
            String nameRunner = input.next();
            runners.add(nameRunner);
            timeLeg1.put(nameRunner, (Double.parseDouble(input.next())));
            timeLeg2.put(nameRunner, (Double.parseDouble(input.next())));
        }
        //let each runner be the first person, then form a team
        LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<>();
        ArrayList<Double> entries = new ArrayList<>();
        for (Map.Entry<String, Double> entry : timeLeg2.entrySet()) {
            entries.add(entry.getValue());
        }
        Collections.sort(entries, new Comparator<Double>() {
            public int compare(Double dbl1, Double dbl2) {
                return (dbl1).compareTo(dbl2);
            }
        });
        for (double num : entries) {
            for (Map.Entry<String, Double> entry : timeLeg2.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        Set<String> SortedSet = sortedMap.keySet();
        String[] namesSorted = SortedSet.toArray(new String[SortedSet.size()]); // [ NAME NAME NAME NAME..] sorted based on leg2 timings
        ArrayList<String> res = null;

        for (int j = 0; j < n; j++) {
            //initialise first member
            String firstRunner = runners.get(j);
            double totalTime = timeLeg1.get(firstRunner);
            ArrayList<String> thisTeam = new ArrayList<String>();
            thisTeam.add(firstRunner);

            //find 3 other members based on their sorted leg2 timings
            for (int k=0; thisTeam.size()<4; k++){
                String currentRunner = namesSorted[k];
                if (currentRunner.equals(firstRunner)) continue;
                else if (! currentRunner.equals(firstRunner)) {
                    totalTime += timeLeg2.get(currentRunner);
                    thisTeam.add(currentRunner);

                }
            }
                if (totalTime < bestTime) {
                bestTime = totalTime;
                res = thisTeam;
            }}
                System.out.println(bestTime);
                for (int x=0; x<4; x++){
                    System.out.println(res.get(x));
                }


    }
}
