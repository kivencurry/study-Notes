package Huawei;
import java.util.HashMap;
/*
* 解题思路：每次寻找出出现元素最大的index，用当前位置j-i+1，得到子串的长度
* */

public class Lee003 {
    public static void main(String[] args) {
        String s = "au";
        System.out.println(new Lee003().lengthOfLongestSubstring(s));
//        String s1="";
//        System.out.println(s1.length());
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 0)
            return 0;
        if (s.length() == 1) {
            return 1;
        }
        int n = s.length();
        int max = 0;
        int dp[] = new int[n];
        dp[0] = 0;
        int j = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) dp[i] = j - i;
            for (; j < n; j++) {
                //第j+1个字符是否出现过
                if (!isOccur(s, i, j)) {
                    max = Math.max(dp[i], max);
                    index = map.get(s.charAt(j));
                    //map 删除i-j的元素
                    int temp = index;
                    while (temp >= i) {
                        map.remove(s.charAt(temp));
                        temp--;
                    }

                    i = index;
                    break;
                } else {
                    dp[i] += 1;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    private boolean isOccur(String s, int start, int end) {
        //采用map来判定第end个字符是否出现过
        if (end < s.length() && map.containsKey(s.charAt(end))) {
            return false;
        } else {
            map.put(s.charAt(end), end);
            return true;
        }
    }
}