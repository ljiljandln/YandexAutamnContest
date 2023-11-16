import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class TaskE {

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
        HashMap<Integer, Node> map = new HashMap<>();
        int count;

        public Node() {}

        public long getSum() {
            long res = 0L;
            if (count > 1) {
                res += (long) count * (count - 1) / 2;
                for (Node node : map.values()) res += node.getSum();
            }
            return res;
        }
    }

    static HashMap<Integer, Node> getMapWithNodes(int[][] arrays) {
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < arrays.length; i++) {
            HashMap<Integer, Node> currMap = map;
            for (int number : arrays[i]) {
                if (!currMap.containsKey(number)) currMap.put(number, new Node());
                currMap.get(number).count++;
                currMap = currMap.get(number).map;
            }
        }
        return map;
    }

    static int[][] getArrays() {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int[][] arrays = new int[n][];
        for (int i = 0; i < n; i++) {
            int k = fs.nextInt();
            arrays[i] = new int[k];
            for (int j = 0; j < k; j++) {
                arrays[i][j] = fs.nextInt();
            }
        }
        return arrays;
    }

    public static void main(String[] args) {
        int[][] arrays = getArrays();

        HashMap<Integer, Node> map = getMapWithNodes(arrays);
        long res = 0L;
        for (Node node : map.values()) {
            res += node.getSum();
        }

        System.out.println(res);
    }
}
