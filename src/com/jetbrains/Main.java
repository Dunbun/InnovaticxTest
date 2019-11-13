package com.jetbrains;

public class Main {

    public static void main(String[] args) {
        MyList obj = new MyList();
        obj.addElement(0,2);
        obj.addElement(1,3);
        obj.addElement(2,4);
        obj.addElement(3,5);
        obj.addElement(-4,20);
        obj.printMyList();
        System.out.println("____________");
        obj.deleteElement(-5);
        obj.printMyList();
        System.out.println("______reverse______");
        obj.reverse(obj);
        obj.printMyList();

    }
}
