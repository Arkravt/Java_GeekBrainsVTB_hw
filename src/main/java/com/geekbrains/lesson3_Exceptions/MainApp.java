package com.geekbrains.lesson3_Exceptions;

import com.geekbrains.lesson3_Exceptions.Exceptions.MyArrayDataException;
import com.geekbrains.lesson3_Exceptions.Exceptions.MyArraySizeException;
import com.geekbrains.lesson3_Exceptions.Exceptions.MyException;

public class MainApp {
    public static void main(String[] args) {

        String perem = "1";

        String[][] arr = {
                {perem, perem, perem, perem},
                {perem, perem, perem, perem},
                {perem, "perem", perem, perem},
                {perem, perem, perem, perem}
        };

        try {
            System.out.println(calculateArraydata(arr));
        } catch (MyException e) {
            e.printStackTrace();
        }

    }

    public static int calculateArraydata(String[][] inputArray) throws MyArraySizeException, MyArrayDataException {
        if (inputArray.length != 4) {
            throw new MyArraySizeException("Ну что, доигрался ? Размер массива не верный !");
        }

        int sum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].length != 4) {
                throw new MyArraySizeException("Ну что, доигрался ? Размер массива не верный !");
            }
            for (int j = 0; j < inputArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(inputArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка: ячейка [" + i + "][" + j + "] содержит не верный формат данных");
                }
            }
        }

        return sum;

    }
}
