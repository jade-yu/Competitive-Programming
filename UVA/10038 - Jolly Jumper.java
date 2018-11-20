import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] t = new int[n];
            
            for(int i=0 ; i<n ; i++) {
                t[i] = sc.nextInt();
            }
            
            if(n > 1) {
                ArrayList<Integer> a = new ArrayList<Integer>();
                for(int i=1 ; i<t.length ; i++) {
                    a.add(Math.abs(t[i] - t[i-1]));
                }
                boolean flag=true;
                for(int i=1 ; i<t.length && flag ; i++) {
                    if(!a.contains(i))
                        flag = false;
                }
                if(flag)
                    System.out.println("Jolly");
                else System.out.println("Not jolly");
            } else System.out.println("Jolly");
        }
    }
}
