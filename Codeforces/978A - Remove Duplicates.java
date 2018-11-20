import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), x;
        ArrayList<Integer> a = new ArrayList<>();
        while(n-->0) {
            x = sc.nextInt();
            if(a.contains(x)) {
                a.remove(a.indexOf(x));
            }
            a.add(x);
        }
        System.out.println(a.size());
        for(int i = 0 ; i < a.size() ; i++) {
            System.out.print(a.get(i) + " ");
        }
    }
}
