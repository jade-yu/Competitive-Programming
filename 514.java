
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        while(n != 0) {
            int next = sc.nextInt();
            while(next != 0) {
                int[] r = new int[n];
                r[0] = next;
                for(int i = 1 ; i < n ; i++) {
                    r[i] = sc.nextInt();
                }
                
                Stack<Integer> s1 = new Stack();
                Stack<Integer> s2 = new Stack();
                
                for(int i = n ; i > 0 ; i--) {
                    s1.push(i+1);
                }
                
                boolean flag = false;
                int index = 0;
                while(!s1.empty()) {
                    int temp = s1.pop();
                    if(temp != r[index]){
                        s2.push(temp);
                    }
                }
            }
            
            n = sc.nextInt();
        }
    }
}
