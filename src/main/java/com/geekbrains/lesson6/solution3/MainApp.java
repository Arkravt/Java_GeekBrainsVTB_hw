package com.geekbrains.lesson6.solution3;

public class MainApp {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    float[] arr;

    public MainApp() {
        arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
    }

    public static void main(String[] args) {
        MainApp el1 = new MainApp();
        MainApp el2 = new MainApp();
        try {
            el1.singleThread();
            el2.multiThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void singleThread() {
        long start = System.currentTimeMillis();
        doSomething(arr);
        System.out.println("Single Thread: " + (System.currentTimeMillis() - start));
    }

    public void multiThread() throws InterruptedException {
        long start = System.currentTimeMillis();

        float[] arrHalf1 = new float[HALF];
        float[] arrHalf2 = new float[HALF];

        System.arraycopy(arr, 0, arrHalf1, 0, HALF);
        System.arraycopy(arr, HALF, arrHalf2, 0, HALF);

        Thread t1 = new Thread(() -> doSomething(arrHalf1));
        Thread t2 = new Thread(() -> doSomething(arrHalf2));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.arraycopy(arrHalf1, 0, arr, 0, HALF);
        System.arraycopy(arrHalf2, 0, arr, HALF, HALF);


        System.out.println("Multi Thread: " + (System.currentTimeMillis() - start));
    }

    public void doSomething(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }


}
