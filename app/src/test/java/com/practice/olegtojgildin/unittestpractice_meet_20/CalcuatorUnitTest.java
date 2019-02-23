package com.practice.olegtojgildin.unittestpractice_meet_20;

import android.util.Log;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;


public class CalcuatorUnitTest {
    private static Calculator mCalculator;
    @BeforeClass
    public static void setCalculator(){
        mCalculator=new Calculator();

    }
    @Test
    public void testAdd1()  {
        assertEquals(5,Calculator.calculate(3,2,Operators.ADD));
    }
    @Test
    public void testAdd2()  {
        assertNotEquals(5,Calculator.calculate(3,6,Operators.ADD));
    }
    @Test
    public void testSub1()  {
        assertEquals(5,Calculator.calculate(15,10,Operators.SUBTRACT));
    }
    @Test
    public void testSub2()  {
        assertNotEquals(5,Calculator.calculate(14,10,Operators.SUBTRACT));
    }
    @Test
    public void testDiv1()  {
        assertEquals(-5,Calculator.calculate(-15,3,Operators.DIVIDE));
    }
    @Test
    public void testDiv2()  {
        assertNotEquals(5,Calculator.calculate(15,15,Operators.DIVIDE));
    }
    @Test(expected = java.lang.ArithmeticException.class)
    public void testDiv3()  {
        assertNotEquals(5,Calculator.calculate(15,0,Operators.DIVIDE));
    }
    @Test
    public void testMult1()  {
        assertEquals(50,Calculator.calculate(5,10,Operators.MULTIPLY));
    }
    @Test
    public void testMult2()  {
        assertNotEquals(50,Calculator.calculate(15,10,Operators.MULTIPLY));
    }
    @Test
    public void testMult3()  {
        assertEquals(0,Calculator.calculate(0,10,Operators.MULTIPLY));
    }

    @Test
    public void testEqualsPrivateAddition() {
        try {
            Method method = mCalculator.getClass().getDeclaredMethod("add", Integer.class, Integer.class);
            method.setAccessible(true);
            assertEquals(12,  method.invoke(mCalculator, 1, 11));
            method.setAccessible(false);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            Log.d("UnitTest",e.getLocalizedMessage());
        }
    }
}