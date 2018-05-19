package com.hit.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class RandomAlgoCacheImplTest 
{

    @Test
    void getElement() 
    {
    	RandomAlgoCacheImpl<Integer,Integer> rand = new RandomAlgoCacheImpl<>(4);
    	@SuppressWarnings("unused")
		Integer res;
    	int resu,x=2;
    	
    	
    	res = rand.putElement(1,1);
    	res = rand.putElement(2,2);
    	res = rand.putElement(3,4);
    	
    	resu = rand.getElement(2);
    	assertEquals(x,resu);

    }

    @Test
    void putElement()
    {
        RandomAlgoCacheImpl<Integer,Integer> rand = new RandomAlgoCacheImpl<>(4);
        Integer res;
        
        res = rand.putElement(1,1);
        assertEquals(null,res);
        
    	res = rand.putElement(2,2);
    	assertEquals(null,res);
    	
    	res = rand.putElement(3,4);
    	assertEquals(null,res);
    	
    	res = rand.putElement(1,4);
    	assertEquals(null,res);
    
    }

    @Test
    void removeElement()
    {
    	RandomAlgoCacheImpl<Integer,Integer> rand = new RandomAlgoCacheImpl<>(4);
		Integer res;
    	
    	res = rand.putElement(1,1);
    	res = rand.putElement(2,2);
    	res = rand.putElement(3,4);
    	
    	rand.removeElement(2);
    	assertEquals(null,res);
    }
}