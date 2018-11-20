import java.util.ArrayList;
import java.util.Scanner;

public class Word {
    static char[][] grid;
    static String[] words;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        grid = new char[N][N];

        for(int i = 0 ; i < N ; i++) {
            String[] s = sc.nextLine().split(" ");
            for(int j = 0 ; j < N ; j++) {
                grid[i][j] = s[j].charAt(0);
            }
        }

        int count = 0;
        words = new String[M];
        for(int i = 0 ; i < M ; i++) {
            words[i] = sc.nextLine();
            boolean flag = false;
            for (int[] pos: findStart(words[i].charAt(0))) {
                if(!flag) {
                    flag = isInGrid(words[i], new ArrayList<>(), pos, 0);
                } else break;
            }
            if(flag){
                count++;
            }
        }
        System.out.println(count);
    }

    static ArrayList<int[]> findStart(char c) {
        ArrayList<int[]> a = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(grid[i][j] == c) {
                    int[] n = new int[2];
                    n[0] = i;
                    n[1] = j;
                    a.add(n);
                }
            }
        }
        return a;
    }

    static boolean isInGrid(String word, ArrayList<String> prev, int[] pos, int index) {
        if(index == word.length() - 1) {
            return true;
        }

//        System.out.println(pos[0] + " " + pos[1] + " " + word.charAt(index));
        if(!prev.contains(pos[0] + "-" + pos[1])) {
            ArrayList<String> next = (ArrayList<String>) prev.clone();
            next.add(pos[0] + "-" + pos[1]);
            boolean flag = false;
            //top
            if(!flag && pos[0] - 1 >= 0 && !prev.contains((pos[0] - 1) + "-" + pos[1]) && grid[pos[0] - 1][pos[1]] == word.charAt(index + 1)) {
                int[] n = new int[2];
                n[0] = pos[0] - 1;
                n[1] = pos[1];
                flag = isInGrid(word, next, n, index + 1);
            }
            //bottom
            if(!flag && pos[0] + 1 < N && !prev.contains((pos[0] + 1) + "-" + pos[1]) && grid[pos[0] + 1][pos[1]] == word.charAt(index + 1)) {
                int[] n = new int[2];
                n[0] = pos[0] + 1;
                n[1] = pos[1];
                flag = isInGrid(word, next, n, index + 1);
            }
            //left
            if(!flag && pos[1] - 1 >= 0 && !prev.contains(pos[0] + "-" + (pos[1] - 1)) && grid[pos[0]][pos[1] - 1] == word.charAt(index + 1)) {
                int[] n = new int[2];
                n[0] = pos[0];
                n[1] = pos[1] - 1;
                flag = isInGrid(word, next, n, index + 1);
            }
            //right
            if(!flag && pos[1] + 1 < N && !prev.contains(pos[0] + "-" + (pos[1] + 1)) && grid[pos[0]][pos[1] + 1] == word.charAt(index + 1)) {
                int[] n = new int[2];
                n[0] = pos[0];
                n[1] = pos[1] + 1;
                flag = isInGrid(word, next, n, index + 1);
            }
            //top left
            if(!flag && pos[0] - 1 >= 0 && pos[1] - 1 >= 0 && !prev.contains((pos[0] - 1) + "-" + (pos[1] - 1)) && grid[pos[0] - 1][pos[1] - 1] == word.charAt(index + 1)) {
                int[] n = new int[2];
                n[0] = pos[0] - 1;
                n[1] = pos[1] - 1;
                flag = isInGrid(word, next, n, index + 1);
            }
            //bottom left
            if(!flag && pos[0] + 1 < N && pos[1] - 1 >= 0 && !prev.contains((pos[0] + 1) + "-" + (pos[1] - 1)) && grid[pos[0] + 1][pos[1] - 1] == word.charAt(index + 1)) {
                int[] n = new int[2];
                n[0] = pos[0] + 1;
                n[1] = pos[1] - 1;
                flag = isInGrid(word, next, n, index + 1);
            }
            //top right
            if(!flag && pos[0] - 1 >= 0 && pos[1] + 1 < N && !prev.contains((pos[0] - 1) + "-" + (pos[1] + 1)) && grid[pos[0] - 1][pos[1] + 1] == word.charAt(index + 1)) {
                int[] n = new int[2];
                n[0] = pos[0] - 1;
                n[1] = pos[1] + 1;
                flag = isInGrid(word, next, n, index + 1);
            }
            //bottom right
            if(!flag && pos[0] + 1 < N && pos[1] + 1 < N && !prev.contains((pos[0] + 1) + "-" + (pos[1] + 1)) && grid[pos[0] + 1][pos[1] + 1] == word.charAt(index + 1)) {
                int[] n = new int[2];
                n[0] = pos[0] + 1;
                n[1] = pos[1] + 1;
                flag = isInGrid(word, next, n, index + 1);
            }
            return flag;
        } else {
            return false;
        }
    }

    static void print() {
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}