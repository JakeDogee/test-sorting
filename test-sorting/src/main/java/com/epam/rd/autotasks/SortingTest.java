package com.epam.rd.autotasks;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortingTest {

    Sorting sorting = new Sorting();

    @Test(expected = IllegalArgumentException.class)
    public void testNullCase() throws IllegalArgumentException{
        int[]arr=null;
        sorting.sort(arr);
    }

    @Test
    public void testEmptyCase(){
        int[] arr = new int[5];
        arr[0] = 8;
        arr[2] = 6;
        int[] arr2 = arr.clone();
        sorting.sort(arr);
        if(sorting.getCallTime()>0) {
            Arrays.stream(arr).forEach(x -> {
                if (!Arrays.stream(arr2).anyMatch(y -> x == y)) throw new ArrayIndexOutOfBoundsException();
            });
            Assert.assertTrue(arr[0] <= arr[arr.length - 1]);
            Assert.assertFalse(Arrays.equals(arr, arr2));
        }

    }

    @Test
    public void testSingleElementArrayCase() {
        int[] arr = new int[1];
        arr[0] = 8;
        int[] exp = arr.clone();
        sorting.sort(arr);
        Assert.assertEquals(Arrays.toString(exp), Arrays.toString(arr));
    }

    @Test
    public void testSortedArraysCase() {
        int[] arr1 = new int[10];
        for (int i = 0; i < arr1.length; i++) {
            int n = (int) (10 + Math.random() * 20);
            arr1[i] = n;
        }
        int[] arr2 = arr1.clone();
        sorting.sort(arr1);
        if(sorting.getCallTime()>0) {
            Assert.assertTrue(arr1[0] == Arrays.stream(arr2).min().getAsInt());
        }
    }

    @Test
    public void testOtherCases() {
        int[] arr1 = new int[10];
        for (int i = 0; i < arr1.length; i++) {
            int n = (int) (10 + Math.random() * 20);
            arr1[i] = n;
        }
        int[] arr2 = arr1.clone();
        sorting.sort(arr1);
        Assert.assertTrue(arr1[0] <= arr1[arr1.length - 1]);
        Assert.assertEquals(Arrays.toString(arr1), Arrays.toString(Arrays.stream(arr2).sorted().toArray()));
    }

}