import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LineScoring {

    static int[] array;
    static HashMap<String, ArrayList<Integer>> lookup;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        array = new int[n];

        for(int i = 0 ; i < n ; i++) {
            array[i] = sc.nextInt();
        }

        lookup = new HashMap<>();

        System.out.println(LineScoring(0, n-1));
    }

    public static ArrayList<Integer> LineScoring(int n, int m) {
        if(lookup.get(n + "-" + m) == null) {
            ArrayList<Integer> a = new ArrayList<>();

            if (n >= m){
                a.add(array[n]);
                return a;
            }

            if (array[n] < array[m]) {
                ArrayList<Integer> i = LineScoring(m, m + 1);
                ArrayList<Integer> j = LineScoring(n, m - 1);
            } else {
            }

            lookup.put(n + "-" + m, a);
            return a;
        } else return lookup.get(n + "-" + m);
    }
}
