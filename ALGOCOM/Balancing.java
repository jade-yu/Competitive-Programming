import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Balancing {
    static List<Integer> a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new ArrayList<>();

        while(n-- > 0) {
            a.add(sc.nextInt());
        }

        boolean flag = false;
        for(int i = 0 ; i < a.size() && !flag ; i++) {
            flag = balance(a.get(i));
        }

        if(flag) {
            System.out.println("YES");
        } else System.out.println("NO");
    }

    static boolean balance(int x) {
        int left = 0, right = 0;
        for(int i = 0 ; i < a.size() ; i++) {
            if(a.get(i) < x) {
                left += a.get(i);
            } else if(a.get(i) > x) {
                right += a.get(i);
            }
        }

        return (left > 0) && (right > 0) && (left == right);
    }
}