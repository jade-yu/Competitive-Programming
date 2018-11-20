import java.util.HashMap;
        import java.util.Scanner;

public class SkiingExhibition {
    static int[][] a;
    static HashMap<String, Integer> lookup;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();

        a = new int[h][3];
        for(int i = 0 ; i < h ; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            a[i][2] = sc.nextInt();
        }

        lookup = new HashMap<>();
        System.out.println(Math.max(Math.max(maxScore(h-1,0), maxScore(h-1, 1)), maxScore(h-1, 2)));
    }

    static int maxScore(int h, int lane) {
        if(lookup.get(h + "-" + lane) == null) {
            if(h == 0) {
                return a[0][lane];
            }

            int score;
            if(lane == 0) {
                score = a[h][0] + Math.max(maxScore(h-1, 0), maxScore(h-1, 1));
            } else if(lane == 1) {
                score = a[h][1] + Math.max(Math.max(maxScore(h-1, 0), maxScore(h-1, 1)), maxScore(h-1, 2));
            } else {
                score = a[h][2] + Math.max(maxScore(h-1, 1), maxScore(h-1, 2));
            }

            lookup.put(h + "-" + lane, score);
            return score;
        } else return lookup.get(h + "-" + lane);
    }
}