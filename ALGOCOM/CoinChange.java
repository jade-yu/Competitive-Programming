import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CoinChange {
    static int c, n;
    static int[] A;
    static HashMap<String, Integer> lookup;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        c = sc.nextInt();
        n = sc.nextInt();

        A = new int[n];
        for(int i = 0 ; i < n ; i++) {
            A[i] = sc.nextInt();
        }

        lookup = new HashMap<>();
        Arrays.sort(A);

        System.out.println(getChange(0, 0));
    }

    public static int getChange(int sum, int i) {
        if(lookup.get(sum + "-" + i) == null) {
            int count = 0;

            while(i < n) {
                int a = A[i];

                if(a + sum == c) {
                    count++;
                    break;
                } else if(a + sum < c) {
                    count += getChange(a + sum, i);
                } else break;

                i++;
            }

            lookup.put(sum + "-" + i, count);
            return count;
        } else return lookup.get(sum + "-" + i);
    }
}