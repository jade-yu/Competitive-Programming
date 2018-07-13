import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static class MutableInt {
      int value = 1;
      public void increment () { ++value;      }
      public int  get ()       { return value; }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        String t;
        Map<String, MutableInt> trees;
        MutableInt count;
        int total, i;
        List keys;
        
        while(n --> 0) {
            keys = new ArrayList<>();
            trees = new HashMap<>();
            total = 0;
            t = sc.nextLine();
            while(!t.isEmpty() || !t.equalsIgnoreCase("\n")) {
                System.out.println(t);
                count = trees.get(t);
                if (count == null) {
                    trees.put(t, new MutableInt());
                    keys.add(t);
                } else {
                    count.increment();
                }
                total++;
                if(sc.hasNext()) {
                    t = sc.nextLine();
                } else {
                    System.out.println("asfjsdfg");
                    break;
                }
            }
            
            Collections.sort(keys);
            DecimalFormat df = new DecimalFormat("#.0000");
            
            for(i = 0 ; i < trees.size(); i++) {
                t = keys.get(i).toString();
                System.out.println(t + " " + df.format(trees.get(t).get() * 100.00f / total));
            }
            
            System.out.println();
        }
        
    }
}
