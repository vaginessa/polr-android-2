package com.jgodha.android.pathofleastresistance;

public class PathOfLeastResistanceMain {

    public static  void  main(String[] args) {
//        String arg = "1 3 5 1 5\;3 8 1 4 9;4 7 1 9 3;9 1 2 8 1;1 3 4 8 2";
//        String arg = "3 4 1 2 8 6;6 1 8 2 7 4;5 9 3 9 9 5;8 4 1 3 2 6;3 7 2 8 6 4";
//        String arg = "3 4 1 2 8 6;6 1 8 2 7 4;5 9 3 9 9 5;8 4 1 3 2 6;3 7 2 1 2 3";
//        String arg = "1 3 5 1;3 8 1 4;4 7 1 9;9 1 2 8";
//        String arg = "1 3 5;3 8 1;4 7 1";
//        String arg = "19 10 19 10 19;21 23 20 19 12;20 12 20 11 10";
        String gridData = args[0];
        System.out.println(new LeastResistantPathFinder().find(gridData.replaceAll(";", "\n")));
    }
}

