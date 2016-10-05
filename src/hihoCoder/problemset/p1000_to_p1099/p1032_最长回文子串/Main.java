package problemset.p1000_to_p1099.p1032_最长回文子串;

import java.util.Scanner;

/**
 * Created by 31798 on 2016/10/2.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < N; i++) {
                String str = sc.nextLine();
                int l = str.length();
                boolean[][] dp = new boolean[l][l];
                dp[0][0] = true;
                for (int j = 1; j < l; j++) {
                    dp[j][j] = dp[j][j - 1] = true;
                }
                int maxLen = 1;
                for (int offset = 1; offset < l; offset++) {
                    for (int j = 0; j + offset < l; j++) {
                        dp[j][j + offset] = dp[j + 1][j + offset - 1] &&
                                str.charAt(j) == str.charAt(j + offset);
                        if (dp[j][j + offset]) {
                            maxLen = offset + 1;
                        }
                    }
                }
                System.out.println(maxLen);
//            }

        }
    }
}
