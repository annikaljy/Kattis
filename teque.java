// link to question: https://open.kattis.com/problems/teque

import java.util.*;
import java.io.*;

public class teque{
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt();
        Tequee teque = new Tequee();

        for (int i = 0; i < n; i++) {
            String command = io.getWord();
            int num = io.getInt();

            if (command.equals("push_front")) {
                teque.pushFront(num);
            } else if (command.equals("push_back")) {
                teque.pushBack(num);
            } else if (command.equals("push_middle")) {
                teque.pushMiddle(num);
            } else if (command.equals("get")) {
                io.println(teque.get(num));
            }
        }

        io.close();
    }
}

class Tequee {
    HashMap firstMap;
    HashMap secondMap;
    int firstPointer;
    int firstSize;
    int secondPointer;
    int secondSize;

    Tequee() {
        this.firstMap = new HashMap<Integer, Integer>();
        this.secondMap = new HashMap<Integer, Integer>();
        this.firstPointer = 0;
        this.firstSize = 0;
        this.secondPointer = 0;
        this.secondSize = 0;
    }

    void pushFront(int item) {
        if (firstSize == secondSize) {
            firstPointer--;
            firstMap.put(firstPointer, item);
            firstSize++;
        } else {
            firstPointer--;
            firstMap.put(firstPointer, item);
            secondPointer--;
            secondMap.put(secondPointer, firstMap.get(firstPointer + firstSize));
            secondSize++;
        }
    }

    void pushMiddle(int item) {
        if (firstSize == secondSize) {
            firstMap.put(firstPointer + firstSize, item);
            firstSize++;
        } else {
            secondPointer--;
            secondMap.put(secondPointer, item);
            secondSize++;
        }
    }
    void pushBack(int item) {
        if (firstSize == secondSize) {
            secondMap.put(secondPointer + secondSize, item);
            firstMap.put(firstPointer + firstSize, secondMap.get(secondPointer));
            secondPointer++;
            firstSize++;
        } else {
            secondMap.put(secondPointer + secondSize, item);
            secondSize++;
        }
    }
    int get(int index) {
        if (index >= firstSize) {
            return (int) secondMap.get(secondPointer + index - firstSize);
        } else {
            return (int) firstMap.get(firstPointer + index);
        }
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
