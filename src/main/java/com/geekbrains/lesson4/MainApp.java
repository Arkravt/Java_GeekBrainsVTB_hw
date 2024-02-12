package com.geekbrains.lesson4;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        String[] myArr = {"he", "2", "3", "4", "5", "6", "7", "8", "9"};
        System.out.println(Arrays.toString(replaceArrayElements(myArr, 0, 5)));

//        replaceArrayElements(myArr, 0, 5);
//        System.out.println(Arrays.toString(myArr));

    }


    public static <T> T[] replaceArrayElements(T[] arr, int firstIndex, int secondIndex) {

        if (secondIndex >= arr.length || firstIndex >= arr.length) {
            System.out.println("Incorrect index ! The array has not changed !");
            return arr;
            //return;
        }

        T temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;

        return arr;
    }

}
