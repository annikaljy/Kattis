// link to question: https://open.kattis.com/problems/coconut

import java.util.*;
public class coconut {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int s = input.nextInt();
        int n = input.nextInt();

        ArrayList<Game> players = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            players.add(new Game(i, 0));
        }

        int idx = 0;
        while (players.size() > 1) {
            idx = (idx + s - 1) % players.size();

            if ((players.get(idx)).folded()) {
                players.get(idx).change();
                players.add(idx, new Game((players.get(idx)).Player(), 1));
            }
            else if ((players.get(idx)).fist()){
                players.get(idx).change();
                idx ++;
            }
            else if ((players.get(idx).palmDown())){
                players.remove(idx);
            }

        }
        System.out.println(players.get(0).Player());
    }
}

class Game{
    public int player;
    public int state;

    Game(int p, int s){
        this.player = p;
        this.state = s;
    }
    int Player(){
        return this.player;
    }
    void change(){
        this.state +=1;
    }
    public boolean folded(){
        return this.state == 0;
    }
    public boolean fist(){
        return this.state == 1;
    }
    public boolean palmDown(){
        return this.state == 2;
    }

}
