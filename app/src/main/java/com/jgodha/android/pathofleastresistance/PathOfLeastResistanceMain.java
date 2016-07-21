package com.jgodha.android.pathofleastresistance;

public class PathOfLeastResistanceMain {

    public static  void  main(String[] args) {
        LeastResistantPathFinder leastResistantPathFinder = new LeastResistantPathFinder();
        if(args.length > 0) {
            String gridData = args[0];
            System.out.println(leastResistantPathFinder.find(gridData.replaceAll(";", "\n")));
        } else {
            //run through the data scenarios mentioned in the kata
            String[] gridData = new String[] {
                    "3 4 1 2 8 6\n6 1 8 2 7 4\n5 9 3 9 9 5\n8 4 1 3 2 6\n3 7 2 8 6 4",
                    "3 4 1 2 8 6\n6 1 8 2 7 4\n5 9 3 9 9 5\n8 4 1 3 2 6\n3 7 2 1 2 3",
                    "19 10 19 10 19\n21 23 20 19 12\n20 12 20 11 10",
                    "1 3 5 1 5\n3 8 1 4 9\n4 7 1 9 3\n9 1 2 8 1\n1 3 4 8 2"
            };

            for(String data : gridData) {
                printGridData(data);
                System.out.println(leastResistantPathFinder.find(data));
                System.out.println("\n");
            }
        }
    }

    private static void printGridData(String gridData) {
        System.out.println("INPUT");
        System.out.println(gridData);
    }
}

