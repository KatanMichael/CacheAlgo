package com.hit.algorithm;

public interface IAlgoCache<K,V> 
{
	/*
		AbstractAlgoCache, 
		LRUAlgoCacheImpl, 
		MRUAlgoCacheImpl, 
		RandomAlgoCacheImpl, 
		SecondChance
	*/
	 
	public Boolean IsFull();
	//returns whether we have reached full capacity or not 
	
	public V getElement(K key);
	//Returns the value to which the specified key is mapped, 
	//or null if this cache contains no mapping for the key.
	
	public V putElement(K key, V value);
	//Associates the specified value with the specified key 
	//in this cache according to the current algorithm
	
	public void removeElement(K key);
	//Removes the mapping for the specified key from this map if present.
	
}
