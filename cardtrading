// link to question: https://open.kattis.com/problems/cardtrading

import java.util.*;

public class cardtrading {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int t = input.nextInt();
        int k = input.nextInt();

        //create array to store T cards
        int[] numbers = new int[100001];
        for (int i=0; i<n; i++){
            int curr = input.nextInt();
            numbers[curr] += 1;
        }

        long Profit = 0;
        //for t cards, put them in array with their selling and buying price
        ArrayList<Price> array = new ArrayList<Price>();
        for (int j =1; j<= t; j++){
            long buying = ((long)(2 - numbers[j]) * input.nextLong());
            long selling = (((long) numbers[j]) * input.nextLong());
            array.add(new Price(numbers[j], buying, selling));
        }
        //return sorted buying+selling
        Collections.sort(array, new Comparing());

        //sell from k to t, buy up to k
        int c = 0;
        while (c<t){
            Price current = array.get(c);
            if (c<k){
                Profit -= current.buy;
            } else { Profit += current.sell; }
            c += 1;
        }
        System.out.println(Profit);

    }
}


class Price{
    public long no;
    public long buy;
    public long sell;

    public Price(long n, long b, long s){
        this.no = n;
        this.buy = b;
        this.sell = s;
    }
    public long getSum() {
        return(buy+sell);
    }

    public long getCard(){
        return(this.no);
    }
    public long getBuy(){return(this.buy);
    }

    public long getSell(){return(this.sell);}
}
class Comparing implements Comparator<Price> {
    public int compare(Price first, Price second) {
        long firstTotal = ((2-first.getCard())*first.getBuy()) + (first.getCard()*first.getSell());
        long secondTotal = ((2-second.getCard())*second.getBuy()) + (second.getCard()*second.getSell());

        if (firstTotal == secondTotal){
            return Long.compare(first.getSell(), second.getSell());
        }
        return Long.compare(first.getSum(), second.getSum());

    }
}
