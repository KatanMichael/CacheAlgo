package com.hit.algorithm;

import static org.junit.jupiter.api.Assertions.*;


class LRUAlgoCacheImplTest
{
    @org.junit.jupiter.api.Test
    void putElement()
    {
        Integer myInt;
        LRUAlgoCacheImpl<Integer,Integer> lru = new LRUAlgoCacheImpl<>(4);

        myInt = lru.putElement(1,2);
        assertEquals(null,myInt);

        myInt = lru.putElement(3,4);
        assertEquals(null,myInt);

        myInt = lru.putElement(1,4);
        assertEquals(null,myInt);
    }

    @org.junit.jupiter.api.Test
    void removeElement()
    {
    	Integer myInt;
        LRUAlgoCacheImpl<Integer,Integer> lru = new LRUAlgoCacheImpl<>(4);

        myInt = lru.putElement(1,2);
        assertEquals(null,myInt);

        myInt = lru.putElement(3,4);
        assertEquals(null,myInt);

        myInt = lru.putElement(5,6);
        assertEquals(null,myInt);

        myInt = lru.putElement(7,8);
        assertEquals(null,myInt);

        lru.removeElement(3);
        myInt = lru.putElement(9,10);
        assertEquals(null,myInt);

    }
    
    @org.junit.jupiter.api.Test
    void getElement()
    {
    	Integer myInt;
    	int x,four = 4;
        LRUAlgoCacheImpl<Integer,Integer> lru = new LRUAlgoCacheImpl<>(4);

        myInt = lru.putElement(600,555);
        assertEquals(null,myInt);

        myInt = lru.putElement(3,4);
        assertEquals(null,myInt);

        myInt = lru.putElement(666,12);
        assertEquals(null,myInt);

        myInt = lru.putElement(1,2);
        assertEquals(null,myInt);
        
        x = lru.getElement(3);
        assertEquals(four,x);
    }
}