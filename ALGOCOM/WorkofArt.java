import java.util.Scanner;

public class WorkofArt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] N = new int[n];

        for(int i = 0 ; i < n ; i++) {
            N[i] = sc.nextInt();
        }

        System.out.println(minStrokes(N));
    }

    static int minStrokes(int[] array) {
        boolean vflag = false, hflag = false;
        int h = 0, v = 0;

        int[] a = array.clone();
        for(int i = 0 ; i < a.length ; i++) {
//            for(int j = 0 ; j < a.length ; j++) {
//                System.out.print(a[j] + " ");
//            }
//            System.out.println("h " + h + " v " + v);
            if(a[i] > 0) {
                a[i]--;
                if(a[i] > 0) {
                    hflag = true;
                }
                if((i < a.length-1 && a[i+1] == 0) || i == a.length-1) {
                    h++;
                }
                if(!vflag){
                    int[] b = array.clone();
                    b[i] = 0;
                    v = 1 + minStrokes(b);
                    vflag = true;
                }
            }
        }
        if(hflag) {
            h += minStrokes(a);
        }

        if(vflag)
            return Math.min(h, v);
        return h;
    }
}