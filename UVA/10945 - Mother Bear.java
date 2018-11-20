import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = "";
        while(true) {
            s = sc.nextLine();
            if(!s.equals("DONE")) {
                s = s.replaceAll("[.,!? ]", "");
                StringBuilder sb = new StringBuilder(s);
                if(s.equalsIgnoreCase(sb.reverse().toString()))
                    System.out.println("You won't be eaten!");
                else System.out.println("Uh oh..");
            } else break;
        }
    }
}
