import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GreedyFarmer {
    static int[][] field, scores;
    static int max = 0, N, M, H;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        int[] start = new int[2];

        field = new int[N][M];
        scores = new int[N][M];

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                field[i][j] = sc.nextInt();
                if(field[i][j] == 0) {
                    start[0] = i;
                    start[1] = j;
                }
            }
            Arrays.fill(scores[i], 0);
        }

        fill(start, new ArrayList<>(), 0, 0);
        System.out.println(max);
    }

    static void fill(int[] pos, ArrayList<String> prev, int score, int steps) {
        if(!prev.contains(pos[0] + "-" + pos[1]) && steps < H) {
            ArrayList<String> next = (ArrayList<String>) prev.clone();
            next.add(pos[0] + "-" + pos[1]);
            int s;
            //left
            if(pos[0] - 1 >= 0 && !prev.contains((pos[0] - 1) + "-" + pos[1])) {
                int[] n = new int[2];
                n[0] = pos[0] - 1;
                n[1] = pos[1];
                s = score + field[pos[0] - 1][pos[1]];
                if(scores[pos[0] - 1][pos[1]] < s) {
                    scores[pos[0] - 1][pos[1]] = s;
                }
                if(max < s){
                    max = s;
                }
                fill(n, next, score + field[pos[0] - 1][pos[1]], steps + 1);
            }
            //right
            if(pos[0] + 1 < M && !prev.contains((pos[0] + 1) + "-" + pos[1])) {
                int[] n = new int[2];
                n[0] = pos[0] + 1;
                n[1] = pos[1];
                s = score + field[pos[0] + 1][pos[1]];
                if(scores[pos[0] + 1][pos[1]] < s) {
                    scores[pos[0] + 1][pos[1]] = s;
                }
                if(max < s){
                    max = s;
                }
                fill(n, next, score + field[pos[0] + 1][pos[1]], steps + 1);
            }
            //up
            if(pos[1] - 1 >= 0 && !prev.contains(pos[0] + "-" + (pos[1] - 1))) {
                int[] n = new int[2];
                n[0] = pos[0];
                n[1] = pos[1] - 1;
                s = score + field[pos[0]][pos[1] - 1];
                if(scores[pos[0]][pos[1] - 1] < s) {
                    scores[pos[0]][pos[1] - 1] = s;
                }
                if(max < s){
                    max = s;
                }
                fill(n, next, score + field[pos[0]][pos[1] - 1], steps + 1);
            }
            //down
            if(pos[1] + 1 < N && !prev.contains(pos[0] + "-" + (pos[1] + 1))) {
                int[] n = new int[2];
                n[0] = pos[0];
                n[1] = pos[1] + 1;
                s = score + field[pos[0]][pos[1] + 1];
                if(scores[pos[0]][pos[1] + 1] < s) {
                    scores[pos[0]][pos[1] + 1] = s;
                }
                if(max < s){
                    max = s;
                }
                fill(n, next, score + field[pos[0]][pos[1] + 1], steps + 1);
            }
//            printScores();
        }
    }

//    static void printScores() {
//        for(int i = 0 ; i < N ; i++) {
//            for(int j = 0 ; j < M ; j++) {
//                System.out.print(scores[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}