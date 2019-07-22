package com.leetcode.design.flattennestedlistiterator;

import java.util.Arrays;
import java.util.List;

public class NestedIntegerValues implements NestedInteger {

    List<NestedInteger> values;


    public NestedIntegerValues(NestedInteger... values) {
        this.values = Arrays.asList(values);
    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return null;
    }

    @Override
    public List<NestedInteger> getList() {
        return values;
    }

    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();
        buff.append('[');
        values.forEach(v -> {
            buff.append(v.toString());
            buff.append(',');
        });
        buff.setCharAt(buff.length() - 1, ']');
        return buff.toString();
    }
}
