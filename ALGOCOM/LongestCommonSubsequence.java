package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LongestCommonSubsequence {

    static int n, m;
    static HashMap<String, Integer> lookup;

    public static void main(String args[]) {

        Scanner c = new Scanner(System.in);

        String a = c.nextLine();
        String b = c.nextLine();

        n = a.length();
        m = b.length();

        lookup = new HashMap<>();

        System.out.println(LCS(a, b, n - 1, m - 1));
    }

    public static int LCS(String a, String b, int n, int m) {
        if(lookup.get(m + "-" + n) == null) {

            if (n == -1 || m == -1)
                return 0;

            if (a.charAt(n) == b.charAt(m)) {
                int i = 1 + LCS(a, b, n - 1, m - 1);
                lookup.put(m + "-" + n, i);
                return i;

            } else {
                int j = Math.max(LCS(a, b, n - 1, m), LCS(a, b, n, m - 1));
                lookup.put(m + "-" + n, j);
                return j;
            }

        } else return lookup.get(m + "-" + n);
    }
}
