package dynamicProgramming;

/**
 * 647. 回文子串
 * 给你一个字符串 s, 请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class LC647 {

    /**
     * 代码随想录题解:
     * https://www.programmercarl.com/0647.%E5%9B%9E%E6%96%87%E5%AD%90%E4%B8%B2.html#%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92
     * 布尔类型的dp[i][j]：表示区间范围[i,j] （左闭右闭）的子串是否是回文子串，如果是,dp[i][j]为true，否则为false。
     * 递推公式
     * 当s[i]与s[j]不相等，dp[i][j]一定是false。
     * 当s[i]与s[j]相等时，有如下三种情况
     * 情况一：下标i 与 j相同，同一个字符例如a，当然是回文子串
     * 情况二：下标i 与 j相差为1，例如aa，也是回文子串
     * 情况三：下标：i 与 j相差大于1的时候，例如cabac，此时s[i]与s[j]已经相同了，我们看i到j区间是不是回文子串就看aba是不是回文就可以了，
     * 那么aba的区间就是 i+1 与 j-1区间，这个区间是不是回文就看dp[i + 1][j - 1]是否为true。
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) { // 注意遍历顺序
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {   // 情况一和情况二
                        result++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) { // 情况三
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return result;
    }
}
