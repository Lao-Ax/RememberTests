package com.alex.jobs;

public class Ozon {

    /*
        Написать функцию, которая печататет строку "<Name> на собеседовании в <company>", по-умолчанию считаем,
        что компания это Ozon, но можно и свою компанию создать.
    */

    public static void printOzon(String name) {
        System.out.println(name + " на собеседовании в Ozon");
    }

    public static void printOzon(String name, String company) {
        System.out.println(name + " на собеседовании в " + company);
    }

    public static void main(String[] args) {
        printOzon("Alex");
        printOzon("Alex", "Another Company");
    }
}
