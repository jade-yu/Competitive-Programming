import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        while (s.contains("xxx")) {
            s = s.replaceFirst("xxx", "xx");
        }
        System.out.println(n - s.length());
    }
}
