package com.java8;

/**
 * No Deadly Diamond Problem here
 */
interface Poet {
    default void write() {
        System.out.println("Poet's default method");
    }
}

interface Writer {
    default void write() {
        System.out.println("Writer's default method");
    }
}

public class Java8InterfaceMultipleInheritanceTest implements Poet, Writer {

    public void write() {
        System.out.println("Writer's AnotherTest method");
    }

    public static void main(String args[]) {
        Java8InterfaceMultipleInheritanceTest anotherTest = new Java8InterfaceMultipleInheritanceTest();
        anotherTest.write(); // which write method to call, from Poet // or, from Writer
    }
}
