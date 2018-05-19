package com.hit.algorithm;

import java.util.*;

public class LRUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V>
{

	private int numOfEntries;
    Hashtable<K,V> hTable;
    Queue<K> keysQueue;

    public LRUAlgoCacheImpl(int capacity)
    {
    	super(capacity); //calls for the father's constructor - MUST
    	
    	numOfEntries = 0;
        this.capacity = capacity;
        hTable = new Hashtable<>();
        keysQueue = new ArrayDeque<>();
    }
    
    public Boolean IsFull()
    {
    	if(numOfEntries == capacity)
    		return true;
    	return false;
    }

    public V getElement(K key)
    {
        V v;
        v= hTable.get(key);

        return v;
    }

    public V putElement(K key, V value)
    {
        V v;
        if(IsFull())
        {
            K k = keysQueue.poll();
            v = hTable.get(k);
            hTable.remove(k);
            keysQueue.add(key);
            hTable.put(key, value);
            return v;

        }
        else
        {
            keysQueue.add(key);
            hTable.put(key,value);
            numOfEntries++;
            return null;
        }
    }

    public void removeElement(K key)
    {
        numOfEntries--;
        hTable.remove(key);
        keysQueue.remove(key);
    }

}