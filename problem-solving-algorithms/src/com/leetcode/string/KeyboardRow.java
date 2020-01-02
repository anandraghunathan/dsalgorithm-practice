package com.leetcode.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        String[] strs = new String[]{"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};

        for(int i = 0; i < strs.length; i++) {
            for(char c : strs[i].toCharArray()) {
                map.put(c, i); //put <char, rowIndex> pair into the map
            }
        }

        List<String> res = new LinkedList<>();
        for(String s : words) {
            //if(s.equals("")) continue;
            int index = map.get(s.toUpperCase().charAt(0));
            for(char c : s.toUpperCase().toCharArray()) {
                if(index != map.get(c)) {
                    index = -1; //don't need a boolean flag.
                    break;
                }
            }

            if(index != -1) {
                res.add(s); //if index != -1, this is a valid string
            }
        }
        /*
             To provide an explanation as to what is going below, the JVM doesn't know how to blindly downcast Object[]
             (the result of toArray()) to String[]. To let it know what your desired object type is, you can pass a
             typed array into toArray(). The typed array can be of any size (new String[1] is valid), but if it is too
             small then the JVM will resize it on it's own.
         */
        return res.toArray(new String[0]); // The reason using "new String[0]" is that type of .toArray() is object[], but we need string[].
    }

    public static void main(String[] args) {
        KeyboardRow obj = new KeyboardRow();
        obj.findWords(new String[]{"Hello","Alaska","Dad","Peace"});
    }
}
