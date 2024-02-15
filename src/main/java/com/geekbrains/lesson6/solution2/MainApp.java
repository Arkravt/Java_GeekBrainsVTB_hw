package com.geekbrains.lesson6.solution2;

public class MainApp {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] arr;

    public static void main(String[] args) {
        singleThread(getFilledArray());
        try {
            multiThread(getFilledArray());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static void singleThread(float[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Single Thread: " + (System.currentTimeMillis() - start));
    }

    static void multiThread(float[] arr) throws InterruptedException {

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
                for (int i = 0; i < arrHalf2.length; i++) {
                    arrHalf2[i] = (float) (arrHalf2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.arraycopy(arrHalf1, 0, arr, 0, HALF);
        System.arraycopy(arrHalf2, 0, arr, HALF, HALF);

        System.out.println("Multi Thread: " + (System.currentTimeMillis() - start));

    }

    static float[] getFilledArray() {
        arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        return arr;
    }
}