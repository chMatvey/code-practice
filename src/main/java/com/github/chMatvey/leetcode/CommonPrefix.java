package com.github.chMatvey.leetcode;

public class CommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        String first = strs[0];
        if (first.isEmpty()) return "";

        for (int i = 0; i < first.length(); i++) {
            char curr = first.charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != curr)
                    return builder.toString();
            }
            builder.append(curr);
        }
        return builder.toString();
    }
}
