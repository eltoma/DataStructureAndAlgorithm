package com.topic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author elto
 * @Description: 分割回文字符串
 * @Create 2021/3/7 下午10:51
 */
public class SplitBackText131 {
    private boolean f[][];
    private List<List<String>> ret = new ArrayList<List<String>>();
    private List<String> ans = new ArrayList<String>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        for(int i = n-1; i >= 0; --i) {
            for(int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i+1][j-1];
            }
        }
        dfs(s, 0);
        return ret;

    }

    public void  dfs(String s, int i) {
        if(i == n) {
           ret.add(new ArrayList<>(ans));
        }

        for(int j = i; j < n; j++) {
            //if(!f[i][j]) { continue; }
            ans.add(s.substring(i, j + 1));
            dfs(s, j + 1);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        SplitBackText131 s = new SplitBackText131();
        final List<List<String>> ret = s.partition("abcd");
        System.out.println("res=" + ret.toString());
    }
}
