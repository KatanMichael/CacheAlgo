package com.hit.algorithm;

import java.util.*;

public class SecondChance <K,V> extends AbstractAlgoCache<K,V>
{
    List<K> listOfKeys;
   // Queue<K> secondChanceKeys;
    List<K> secondChanceKeys;
    private Hashtable<K, V> hashtable;
    private int numberOfEntries;

    public SecondChance(int capacity)
    {
    	super(capacity);
    	
    	listOfKeys = new ArrayList<>();
       // secondChanceKeys = new ArrayDeque<>();
        secondChanceKeys = new  ArrayList<>();
        numberOfEntries = 0;
        hashtable = new Hashtable<>();
    }
    
    public Boolean IsFull()
    {
    	if(numberOfEntries == capacity)
    		return true;
    	return false;
    }

    public V getElement(K key) 
    {
        V v;
        v = hashtable.get(key);
        
        return v;
    }

    public V putElement(K key, V value) 
    {
        V v = hashtable.get(key);
        K tempK;
        int i=0;
        
        if (v != null) 
        {
            if (v == value) 
	            {
	                if (!secondChanceKeys.contains(key)) 
	                    secondChanceKeys.add(key);
	                return null;
	            }
        }
        
        if (IsFull()) 
        {
            while (i < listOfKeys.size()) 
            {
                tempK = listOfKeys.get(i);
                
                if (! secondChanceKeys.contains(tempK)) 
                {
                    tempK = listOfKeys.get(i);
                    
                    v = hashtable.get(tempK);
                    listOfKeys.remove(tempK);
                    hashtable.remove(tempK);
                    
                    listOfKeys.add(key);
                    hashtable.put(key, value);
                    
                    i = listOfKeys.size() + 1;
                } 
                else
                {
                    secondChanceKeys.remove(tempK);
                    i++;
                    
                    //in case all entries have second chance
                    //the return will just be the V we got as parameter
                    //and it will not get in the list of keys
                } 
            }
        } 
        
        else 
        {
            hashtable.put(key, value);
            numberOfEntries++;
            listOfKeys.add(key);
        }
        return v;
    }

    public void removeElement(K key) 
    {
    	//System.out.println("Key = " + key.toString() + " Value = " + getElement(key).toString());
    	numberOfEntries--;
    	//System.out.println("numberOfEntries = " + numberOfEntries );
        hashtable.remove(key);
       // System.out.println("Removed from hash table");
        listOfKeys.remove(key);
       // System.out.println("Removed from hash listOfKeys");
        secondChanceKeys.remove(key);
      //  System.out.println("Removed from hash secondChanceKeys");
    }
}