import java.util.ArrayList;
import java.util.Scanner;

public class Points {
    static ArrayList<ArrayList<Integer>> partners;
    static int S;
    static int D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        S = sc.nextInt();
        D = sc.nextInt();

        partners = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            int M = sc.nextInt();
            ArrayList<Integer> p = new ArrayList<>();
            while(M-- > 0) {
                p.add(sc.nextInt());
            }
            partners.add(p);
        }

        ArrayList<Integer> prev = new ArrayList<>();
        prev.add(S);
        System.out.println(getWays(prev, S));
    }

    public static int getWays(ArrayList<Integer> prev, int curr) {
        if(curr == D) {
            return 1;
        } else {
            int ways = 0;
            for (int p: partners.get(curr - 1)) {
                if(!prev.contains(p)) {
                    ArrayList<Integer> next = (ArrayList<Integer>) prev.clone();
                    next.add(p);
                    ways += getWays(next, p);
                }
            }
            return ways;
        }
    }
}