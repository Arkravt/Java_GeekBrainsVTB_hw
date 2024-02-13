package com.geekbrains.lesson4.collectionMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionsMethods {

    public static void replaceArrayElements(Object[] arr, int firstIndex, int secondIndex) {

        if (secondIndex >= arr.length || firstIndex >= arr.length) {
            System.out.println("Incorrect index ! The array has not changed !");
            return;
        }

        Object temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public static <T> List<T> convertArrayToArrayList(T[] arr) {
        return Arrays.asList(arr);
    }


}
