package com.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MathProblem {
    public static void main(String args[]) {
//        int n = 1000;
//        for (int a = 1; a <= 1000; a++) {
//            for (int b = 1; b <= 1000; b++) {
//                for (int c = 1; c <= 1000; c++) {
//                    for (int d = 1; d <= 1000; d++) {
//                        if((Math.pow(a, 3) + Math.pow(b, 3)) == (Math.pow(c, 3) + Math.pow(d, 3))) {
//                            System.out.println(" "+a +" "+b  +" " +c  +" "+d);
//                        }
//                    }
//                }
//            }
//
//        }

        class Pair {
            int a;
            int b;

            public Pair(int x, int y) {
                a = x;
                b = y;
            }
        }

        long sumOfC3AndD3;
        HashMap<Long, ArrayList<Pair>> listOfCAndDMap = new HashMap<>();
        for (int c = 1; c <= 1000; c++) {
            for (int d = 1; d <= 1000; d++) {
                sumOfC3AndD3 = Math.round(Math.pow(c, 3) + Math.pow(d, 3));

                if(listOfCAndDMap.containsKey(sumOfC3AndD3)) {
                    List<Pair> listOfPairs = listOfCAndDMap.get(sumOfC3AndD3);
                    for(Pair p: listOfPairs) {
                        System.out.println(p.a + " " +p.b + " " + c + " "+ d + " ");
                    }
                }
               else {
                    ArrayList<Pair> emptyListOfPairs = new ArrayList<>();
                    listOfCAndDMap.put(sumOfC3AndD3, emptyListOfPairs);
                }
                listOfCAndDMap.get(sumOfC3AndD3).add(new Pair(c, d));
            }
        }
    }
}
