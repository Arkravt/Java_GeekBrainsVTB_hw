package com.geekbrains.lesson6_Multithreading_Part1;

import java.util.Arrays;

public class MainApp {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] arr = new float[SIZE];

    public static void main(String[] args) {
        singleThread();
        multiThread();
    }


    static void singleThread() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Single Thread: " + (System.currentTimeMillis() - start));

    }

    static void multiThread() {
        Arrays.fill(arr, 1.0f);
        long start = System.currentTimeMillis();
        float[] arrHalf1 = new float[HALF];
        float[] arrHalf2 = new float[HALF];
        System.arraycopy(arr, 0, arrHalf1, 0, HALF);
        System.arraycopy(arr, HALF, arrHalf2, 0, HALF);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrHalf1.length; i++) {
                    arrHalf1[i] = (float) (arrHalf1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0, j = HALF; i < arrHalf2.length; i++, j++) {
                    arrHalf2[i] = (float) (arrHalf2[i] * Math.sin(0.2f + j/ 5) * Math.cos(0.2f + j/ 5) * Math.cos(0.4f + j/ 2));
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arrHalf1, 0, arr, 0, HALF);
        System.arraycopy(arrHalf2, 0, arr, HALF, HALF);
        System.out.println("Multi Thread: " + (System.currentTimeMillis() - start));
    }
}