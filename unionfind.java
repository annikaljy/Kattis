// link to question: https://open.kattis.com/problems/almostunionfind

import java.util.*;

public class almostunionfind {
    static int[] parent = new int[10000];
    static int[] cont = new int[10000];
    static long[] sum = new long[10000];

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        else {
            int check = (parent[x] = find(parent[x]));
            return check;
        }
    }
    static void Set(int n) {
        int size = n*2+1;
        parent = new int[size];
        sum = new long[size];
        cont = new int[size];
        for (int i = 1; i <= n; i++) {
            int j = i + n;
            parent[i] = j;
            parent[j] = j;
            sum[j] = j - n;
            cont[j] = 1;
        }
    }

    static void merge(int x, int y) {
        if (find(x) != find(y) ) {
            x = find(x);
            y = find(y);
            cont[y] += cont[x];
            sum[y] += (sum[x]);
            parent[x] = y;
        }
    }

    static void move(int x, int y) {
        if (find(x) != find(y)) {
            int xroot = find(x);
            int yroot = find(y);
            cont[yroot]++;
            cont[xroot]--;
            sum[yroot] += x;
            sum[xroot] -= x;
            parent[x] = yroot;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            int n = input.nextInt();
            int m = input.nextInt();

            Set(n);

            for (int i = 0; i < m; i++) {
                int cmd = input.nextInt();

                if (cmd == 1) {
                    merge(input.nextInt(), input.nextInt());
                } else if (cmd == 2) {
                    move(input.nextInt(), input.nextInt());
                } else {
                    int p = input.nextInt();
                    System.out.println(cont[find(p)] + " " + sum[find(p)]);
                }
            }
        }
    }
}
