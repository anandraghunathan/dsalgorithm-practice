package com.leetcode.design.flattennestedlistiterator;

import java.util.ArrayList;
import java.util.List;

public class NestedIntegerValue implements NestedInteger {

    Integer value;

    public NestedIntegerValue(Integer v){
        value = v;
    }

    @Override
    public boolean isInteger() {
        return true;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
