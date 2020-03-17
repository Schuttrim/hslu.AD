package ch.hslu.tree;

import java.util.ArrayList;
import java.util.List;

public class TreePerformanceTesting {
    public static void main(final String[] args){
        final int amount = 1000000;
        var numbers = generateRandomNumbers(amount);

        var beforeMyTreeSet = System.currentTimeMillis();
        Tree<Double> tree = TreeSet.CreateSortedByHashcode();
        for (Double number : numbers) {
            tree.add(number);
        }
        var afterMyTreeSet = System.currentTimeMillis();
        System.out.println("Adding " + amount + " Elements to my Treeset took " + (afterMyTreeSet-beforeMyTreeSet) + " milliseconds");

        for(Double number : numbers ){
            if (!tree.has(number)){
                throw new Error("Tammisiech!");
            }
        }

        var beforeDeprecatedTreeSet = System.currentTimeMillis();
        java.util.TreeSet<Double> utilTree = new java.util.TreeSet<Double>();
        for (Double number : numbers) {
            utilTree.add(number);
        }
        var afterDeprecatedTreeSet = System.currentTimeMillis();
        System.out.println("Adding " + amount + " Elements to my java.util.TreeSet took " + (afterDeprecatedTreeSet-beforeDeprecatedTreeSet) + " milliseconds");

    }

    public static List<Double> generateRandomNumbers(int amount){
        var list = new ArrayList<Double>();
        for (int i = 0; i < amount; i++){
            list.add(Math.random());
        }
        return list;
    }
}
