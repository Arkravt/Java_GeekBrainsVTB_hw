package com.geekbrains.lesson2_OOP_Advanced_level.solution1.moving;

public enum TypeOfMoving {
    HUMAN("Человек"), CAT("Кот"), ROBOT("Робот");

    private String russianTitle;

    public String getRussianTitle() {
        return russianTitle;
    }

    TypeOfMoving(String russianTitle) {
        this.russianTitle = russianTitle;
    }

}
