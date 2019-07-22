package com.leetcode.design.flattennestedlistiterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 *
 * Similar problems TO-DO (Leetcode Premium):
 *          Flatten 2D Vector
 *          Zigzag Iterator
 *
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack();

        // Call the flatten list function push the list entries into a stack
        flattenList(nestedList);
    }

    @Override
    public Integer next() {
        /*
            Call the hasNext function again to check if an element exist, if it does,
            pop from the stack and return the integer. If not, return null
        */
        return hasNext() ? stack.pop().getInteger() : null;
    }

    @Override
    public boolean hasNext() {

        // Iteratively check if the stack is empty for each element inside the stack
        while(!stack.isEmpty()) {
            /*
                Check if the element in the stack is an integer, if it is, return true.
                If the element is not an integer, meaning it is a list of list, continue to
                flatten the list again by calling the flatten list function, by popping the
                top element in the stack
            */
            if(stack.peek().isInteger())
                return true;

            /*
                Flatten the list further from list of list till the element is
                an integer and not list of list
            */
            flattenList(stack.pop().getList());
        }
        return false;
    }

    /*
    Input List: [1, [4, [6]]] will flattened to 1, 4, 6.
    First level: [1, [4, [6]]],
    2nd level  :  [4, [6]]
    3rd level  :  [6]
    */
    public void flattenList(List<NestedInteger> list) {
        for(int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
    }

    public static void main(String[] args) {
        List<NestedInteger> nestedList = Arrays.asList(
                new NestedIntegerValue(1),
                new NestedIntegerValues(
                        new NestedIntegerValue(4),
                                new NestedIntegerValues(
                                    new NestedIntegerValue(6))));

        System.out.println(nestedList);
        NestedIterator nestedIterator = new NestedIterator(nestedList);

        System.out.print("[");
        while (nestedIterator.hasNext()) {
            System.out.print(" ");
            System.out.print(nestedIterator.next() + ",");
        }
        System.out.print("]");
    }
}
