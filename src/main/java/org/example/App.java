package org.example;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 John Slauter
 */

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {

        Scanner s = new Scanner(System.in);

        String[] temp = new String[2];

        double t;

        char choice;

        boolean is_celsius = true;

        System.out.print("Press C to convert from Fahrenheit to Celsius.\n" +
                "Press F to convert from Celsius to Fahrenheit.\n" +
                "Your choice: ");

        choice = s.nextLine().charAt(0);

        if(choice == 'c' || choice == 'C'){

            is_celsius = false;

        }

        System.out.print(String.format("Please enter the temperature in %s: ", is_celsius ? "Celsius" : "Fahrenheit"));

        t = s.nextDouble();

        t = is_celsius ? C_to_F(t) : F_to_C(t);

        System.out.print(String.format("The temperature in %s is %f.", is_celsius ? "Celsius" : "Fahrenheit", t));

        s.close();

    }

    private static double F_to_C(double t){

        return (t - 32) * 5 / 9;

    }

    private static double C_to_F(double t){

        return t * 9 / 5 - 32;

    }

    private static int String_to_Int(String num){

        int res = 0;

        for(int i = 0; i < num.length(); i++){

            res += (num.charAt(i)-'0')*pow(10, num.length()-1-i);

        }

        return res;

    }

    private static double String_to_Double(String num){

        double res = 0.0;

        int decimal_index = num.indexOf("."), flag = 1;

        if(decimal_index == -1){

            return(String_to_Int(num));

        }

        for(int i = 0; i < num.length(); i++) {

            if (i == decimal_index) {

                flag = 0;

                continue;

            }

            res += (num.charAt(i) - '0') * pow(10, decimal_index - flag - i);

        }

        return res;

    }

    private static double pow(int base, int exponent){

        if(exponent < 0){

            pow_neg_exp(base, -1*exponent);

        }

        int res = 1;

        for(int i = 0; i < exponent; i++){

            res *= base;

        }

        return res;

    }

    private static double pow_neg_exp(int base, int exponent){

        double res = 1;

        for(int i = 0; i < exponent; i++){

            res /= base;

        }

        return res;

    }

}
