package com.jetbrains;

public class Main {

    public static void main(String[] args) {
        CycleList testCycleList = new CycleList();
        testCycleList.addElement(0,2);
        testCycleList.addElement(1,3);
        testCycleList.addElement(2,4);
        testCycleList.addElement(3,5);
        testCycleList.addElement(-4,20);
        testCycleList.printCycleList();
        System.out.println("____________");
        testCycleList.deleteElement(-5);
        testCycleList.printCycleList();
        System.out.println("______reverse______");
        testCycleList.reverse(testCycleList);
        testCycleList.printCycleList();

    }
}
