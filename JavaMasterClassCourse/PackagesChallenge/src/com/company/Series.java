package com.company;

public class Series {
    private static long sum, product;

    public static long nSum(int n) {
        return sum += n;
    }

    public static long factorial(int n) {
        if(n == 0) {
            product = 0;
        } else if(n == 1) {
            product = 1;
        }
        return product *= n;
    }


    public static int fibonacci(int n) {
        if(n == 0) return 0;
        else if(n ==1) return 1;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

}
