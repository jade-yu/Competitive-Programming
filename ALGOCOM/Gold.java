import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Gold {
    static int N, C;
    static ArrayList<double[]> values;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        C = sc.nextInt();

        values = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            double[] v = new double[3];
            v[0] = sc.nextDouble();
            v[1] = sc.nextInt();
            v[2] = v[0] / v[1];
            values.add(v);
        }
        Collections.sort(values, new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                if(a[2] > b[2])
                    return -1;
                else if(a[2] < b[2])
                    return 1;
                else return 0;
            }
        });

        System.out.printf("%.2f", getMax(0, 0, 0));
    }

    static double getMax(double weight, double value, int index) {
        if(C == weight) {
            return value;
        } else {
            if(weight + values.get(index)[1] > C) {
                return getMax(C, value + values.get(index)[2] * (C - weight), index);
            } else {
                while(weight + values.get(index)[1] <= C && index < N) {
                    weight += values.get(index)[1];
                    value += values.get(index)[0];
                    index++;
                }
                return getMax(weight, value, index);
            }
        }
    }
}