package com.hit.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unused")
class SecondChanceTest 
{

    @Test
    void getElement() 
    {
    	SecondChance<Integer, Integer> secondChance = new SecondChance<>(3);
        int x=2, res;

       secondChance.putElement(1, 1);
       secondChance.putElement(2, 2);
       secondChance.putElement(3, 3);
        
        res = secondChance.getElement(2);
        assertEquals(x, res);

    }

    @Test
    void putElement() {

        SecondChance<Integer, Integer> secondChance = new SecondChance<>(3);
        Integer myInt;

        myInt = secondChance.putElement(1, 1);
        assertEquals(null, myInt);

        myInt = secondChance.putElement(2, 2);
        assertEquals(null, myInt);

        myInt = secondChance.putElement(1, 1);
        assertEquals(null, myInt);

        myInt = secondChance.putElement(3, 3);
        assertEquals(null, myInt);

        myInt = secondChance.putElement(4, 4);
        assertEquals(2, myInt.hashCode());

        myInt = secondChance.putElement(1, 1);
        assertEquals(null, myInt);

        myInt = secondChance.putElement(2, 2);
        assertEquals(3, myInt.hashCode());

       myInt = secondChance.putElement(5, 5);
       assertEquals(1, myInt.hashCode());
       //key "5" removed the key "1" - hence our return v equals 1
    }

    @Test
    void removeElement() 
    {
    	SecondChance<Integer, Integer> secondChance = new SecondChance<>(4);
        int x=2;
        Integer res;

       secondChance.putElement(1, 1);
       secondChance.putElement(2, 2);
       secondChance.putElement(3, 3);
       secondChance.putElement(3, 5);

       
      secondChance.removeElement(x);
      res = secondChance.getElement(x);
      assertNotEquals(2, res);
       
    }
}