import java.util.Scanner;

public class LikelyTrail {
    static int[][][] M;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        M = new int[n][m][n];

        for(int a = 0 ; a < n ; a++) {
            for(int i = 0 ; i < m ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    M[a][i][j] = sc.nextInt();
                }
            }
        }

        int k = sc.nextInt(), currLoc = 0;
        int[] K = new int[k];
        System.out.print("1");
        for(int i = 0 ; i < k ; i++) {
            K[i] = sc.nextInt();

            currLoc = nextLocation(currLoc, K[i] - 1);
            System.out.print("->" + (currLoc + 1));
        }
    }

    static int nextLocation(int curr, int msg) {
        int max = 0;
        for(int i = 1 ; i < n ; i++) {
            if(M[curr][msg][i] > M[curr][msg][max]) {
                max = i;
            }
        }
        return max;
    }
}