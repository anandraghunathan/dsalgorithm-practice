package com.ctci.string;

public class URLify {
    public static void main(String[] args) {

        char[] input = "Mr John Smith             ".toCharArray();
        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
        urlify(input, 13);
    }

    public static void urlify(char[] input, int trueInputLength) {
        int spaceCount = 0, index, i = 0;

        for(i = 0; i < trueInputLength; i++) {
            if(input[i] == ' ') {
                spaceCount++;
            }
        }

        index = trueInputLength + spaceCount * 2;

        if(trueInputLength < input.length) input[trueInputLength] = '\0';

        for(i = trueInputLength - 1; i >= 0; i--) {
            if(input[i] == ' ') {
                input[index - 1] = '0';
                input[index - 2] = '2';
                input[index - 3] = '%';
                index -= 3;
            } else {
                input[index - 1] = input[i];
                index--;
            }
        }
        System.out.println(" ");
        System.out.println(input);
    }
}
