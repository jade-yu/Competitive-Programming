import java.util.Scanner;
import java.lang.Math;

public class BallDrop {
    public static void Drop(int N, int D, double I) {
        if (D == 1)
            System.out.println(N);
        else if (I % 2 == 0) {
            Drop(2*N+1, D-1, Math.floor(I/2)) ;
        }
        else {
            Drop(2*N, D - 1, Math.ceil(I/2));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int depth;
        double i;
        depth = sc.nextInt();
        i = sc.nextInt();

        Drop(1, depth, i);
    }
}