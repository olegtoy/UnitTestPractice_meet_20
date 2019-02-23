package com.practice.olegtojgildin.unittestpractice_meet_20;

/**
 * Created by olegtojgildin on 23/02/2019.
 */

public class Calculator {

    public static int calculate(int value1,int value2, Operators operators) {
        int res=0;
        switch (operators) {
            case ADD:
                res=add(value1,value2);
                break;
            case SUBTRACT:
                res=subtract(value1,value2);
                break;
            case MULTIPLY:
                res=multiply(value1,value2);
                break;
            case DIVIDE:
                res=divide(value1,value2);
                break;
            default:
                break;
        }
        return res;
    }

    private static int add(Integer value1,  Integer value2) {
        return value1 + value2;
    }

    public static int subtract(int value1,  int value2) {
        return value1 - value2;
    }

    public static int multiply(int value1, int value2) {
        return value1 * value2;
    }

    public static int divide( int value1,  int value2) {
        return value1 / value2;
    }
}

