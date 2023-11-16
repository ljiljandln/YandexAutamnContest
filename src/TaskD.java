import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class TaskD {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static class Node {
        Node parent;
        int id;
        int distanceToA;
        int distanceToB;
        int resultDistance;
        public Node() {}

        public Node(Node parent, String language, int id) {
            this.id = id;
            this.parent = parent;
            if (language.equals("A")) {
                resultDistance = parent.distanceToA;
                distanceToA = 0;
                distanceToB = parent.distanceToB + 1;
            } else {
                resultDistance = parent.distanceToB;
                distanceToB = 0;
                distanceToA = parent.distanceToA + 1;
            }
        }
    }

    static class Tree {
        int[] resultArray;
        int size;

        public Tree(int count, int[] numbers, String[] languages) {
            resultArray = new int[count];
            Node parent = new Node();
            for (int i = 1; i < numbers.length; i++) {
                int id = numbers[i];
                if (id != numbers[i - 1] && id != parent.id) {
                    Node node = new Node(parent, languages[id], id);
                    resultArray[node.id - 1] = node.resultDistance;
                    parent = node;
                    if (++size == count) break;
                } else {
                    parent = parent.parent;
                }
            }
        }

        public void printRes() {
            StringBuilder sb = new StringBuilder();
            for (int distance : resultArray) sb.append(distance).append(" ");
            System.out.print(sb);
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        String[] languages = new String[n + 2];
        for (int i = 1; i <= n; i++) {
            languages[i] = fs.next();
        }

        int[] numbers = new int[2 * (n + 1)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = fs.nextInt();
        }

        Tree tree = new Tree(n, numbers, languages);
        tree.printRes();
    }
}
