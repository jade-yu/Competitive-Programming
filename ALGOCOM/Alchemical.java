import java.util.ArrayList;
import java.util.Scanner;

public class Alchemical {
    static ArrayList<Integer> potions;
    static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        T = sc.nextInt();

        potions = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            potions.add(sc.nextInt());
        }

        ArrayList<Integer> prev = new ArrayList<>();
        System.out.println(getWays(0, 0));
    }

    public static int getWays(int sum, int index) {
        int count = 0;

        if(sum + potions.get(index) == T) {
            count++;
        }

        if(index < potions.size() - 1) {
            count += getWays(sum, index + 1);
            count += getWays(sum + potions.get(index), index + 1);
        }

        return count;
    }
}