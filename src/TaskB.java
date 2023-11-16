import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TaskB {

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
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

    static class Game {
        final private HashMap<Integer, Integer> cardDeck1;
        final private HashMap<Integer, Integer> cardDeck2;
        private int res;

        public Game(int[] arr1, int[] arr2) {
            cardDeck1 = getCardDeckMap(arr1);
            cardDeck2 = getCardDeckMap(arr2);
            res = removeMatchingCards();
        }

        public int getRes() {
            return res;
        }

        private HashMap<Integer, Integer> getCardDeckMap(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int card : arr) {
                if (!map.containsKey(card)) map.put(card, 0);
                map.replace(card, map.get(card) + 1);
            }
            return map;
        }

        private int removeMatchingCards() {
            int res = 0;
            for (int card : cardDeck1.keySet()) {
                if (cardDeck2.containsKey(card)) {
                    int count1 = cardDeck1.get(card), count2 = cardDeck2.get(card);
                    int min = Math.min(count1, count2);
                    cardDeck1.replace(card, count1 - min);
                    cardDeck2.replace(card, count2 - min);
                }
                res += cardDeck1.get(card);
            }
            int sum2 = cardDeck2.values().stream().reduce(Integer::sum).get();
            return res + sum2;
        }

        private int getDiff(int card) {
            if (!cardDeck1.containsKey(card) && !cardDeck2.containsKey(card)) {
                return 0;
            } else if (cardDeck1.containsKey(card) && !cardDeck2.containsKey(card)) {
                return cardDeck1.get(card);
            } else if (!cardDeck1.containsKey(card) && cardDeck2.containsKey(card)) {
                return cardDeck2.get(card);
            }
            return Math.abs(cardDeck1.get(card) - cardDeck2.get(card));
        }

        private void makeCardMove(int type, String player, int card) {
            int diffBefore = getDiff(card);
            if (player.equals("A")) {
                if (!cardDeck1.containsKey(card)) cardDeck1.put(card, 0);
                cardDeck1.replace(card, cardDeck1.get(card) + type);
            } else {
                if (!cardDeck2.containsKey(card)) cardDeck2.put(card, 0);
                cardDeck2.replace(card, cardDeck2.get(card) + type);
            }
            int diffAfter = getDiff(card);
            res += (diffBefore > diffAfter) ? -1 : 1;
        }
    }

    static int[] getIntArray(FastScanner fs, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = fs.nextInt();
        return arr;
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt(), m = fs.nextInt(), q = fs.nextInt();

        int[] arr1 = getIntArray(fs, n);
        int[] arr2 = getIntArray(fs, n);
        Game game = new Game(arr1, arr2);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int type = fs.nextInt();
            String pl = fs.next();
            int card = fs.nextInt();

            game.makeCardMove(type, pl, card);
            sb.append(game.getRes()).append(" ");
        }
        System.out.print(sb);
    }
}
