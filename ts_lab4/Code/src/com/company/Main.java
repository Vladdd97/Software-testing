package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Introdu virsta:");

        int age = reader.nextInt();

        if(age < 15){
            System.out.println("Munca interzisa!");
        }
        else if (age >= 15 && age < 16){
            System.out.println("Munca permisa doar cu acordul parintilor cu o durata zilnica mai mica de 5 ore.");
        }
        else if(age >= 16 && age < 18){
            System.out.println("Munca permisa cu o durata zilnica de pina la 7 ore.");
        }
    }
}
