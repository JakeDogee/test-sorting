package com.epam.rd.autotasks;

import java.util.Arrays;
import java.util.Objects;

public class Sorting {
    int callTime = 0;
    public void sort(int[] array) throws IllegalArgumentException{
        if(array == null || Arrays.stream(array).anyMatch(Objects::isNull))
            throw new IllegalArgumentException();
        else{
            int[]nums = Arrays.stream(array).sorted().toArray();
            for (int i = 0; i < nums.length; i++) {
                array[i]=nums[i];
            }
        }
        callTime++;
    }

    public int getCallTime() {
        return callTime;
    }
}
