package com.ctci.string;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compressString("abbbcdefghij"));
    }

    public static String compressString(String str) {
        int n = str.length();
        StringBuilder compressed = new StringBuilder();
        int compressionCount = 0;
        for(int i = 0; i < n; i++) {
            compressionCount++;
            if(i + 1 >= n || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(compressionCount);
                compressionCount = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}
