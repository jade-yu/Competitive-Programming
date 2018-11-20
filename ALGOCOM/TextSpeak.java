import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        switch (s.charAt(0)) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
                s = s.charAt(0) + s.replaceAll("[aeiou]", "");
                break;
            default:
                s = s.replaceAll("[aeiou]", "");
        }

        int i = 0;
        while(i < s.length() - 1) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                s = s.substring(0, i) + s.substring(i + 1, s.length());
            } else i++;
        }

        System.out.print(s);
    }
}
