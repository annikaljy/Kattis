// link to question: https://open.kattis.com/problems/joinstrings

import java.io.*;
import java.util.*;

public class joinstrings {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();
        Index[] words = new Index[n];

        for (int i = 0; i < n; i++) {
            String word = io.getWord();
            words[i] = new Index(word);
        }

        Index update;
        Index original;
        int[] arr = new int[]{1, 1};
        for (int i = 0; i < n - 1; i++) {
            arr[0] = io.getInt();
            arr[1] = io.getInt();

            update = words[arr[0] - 1];
            original = words[arr[1] - 1];

            update.tail.after = original;
            update.tail = original.tail;
        }

        Index current = words[arr[0] - 1];
        while (current != null) {
            io.print(current.word);
            current = current.after;
        }

        io.close();
    }
}


class Kattio extends PrintWriter {
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public int getInt() {
        return Integer.parseInt(next());
    }
    public String getWord() {
        return next();
    }


    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peek() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) {
            }
        return token;
    }

    private String next() {
        String ans = peek();
        token = null;
        return ans;
    }
}
class Index {
    public Index first;
    public Index after;
    public String word;
    public Index tail;

    public Index (String word) {
        this.word = word;
        this.after = null;
        this.first = null;
        this.tail = this;
    }
}
