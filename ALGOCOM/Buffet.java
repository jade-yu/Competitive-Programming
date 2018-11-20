import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Buffet {
    static ArrayList<int[]> dept;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dept = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            int[] t = new int[2];
            t[0] = sc.nextInt();
            t[1] = sc.nextInt();
            dept.add(t);
        }
        Collections.sort(dept, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] > b[0])
                    return 1;
                else if(a[0] < b[0])
                    return -1;
                else return 0;
            }
        });

        System.out.println(minDays(1));
    }

    static int minDays(int time) {
        int days = 1;
        while(dept.size() > 0) {
//            System.out.println("day " + days);
            int i = 0;
            while(i < dept.size() && time <= dept.get(dept.size() - 1)[0]) {
                if(time <= dept.get(i)[0]) {
                    int[] d = dept.get(i);
                    dept.remove(i);
//                    System.out.println(d[0] + " " + (d[0] + d[1]));
                    time = d[0] + d[1];
                    if(time > 24) {
                        time %= 24;
                        days++;
                    }
                } else i++;
            }
            if(dept.size() > 0) {
                days++;
                time = 1;
            }
        }
        return days;
    }
}