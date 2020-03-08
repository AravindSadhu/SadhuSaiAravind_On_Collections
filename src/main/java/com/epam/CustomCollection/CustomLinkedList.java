package com.epam.CustomCollection;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLinkedList<T> {
	private static Logger logger = LogManager.getLogger(Collection.class);
	private int size = 0;
    private static int DEFAULT_CAPACITY = 10;
    private Object mycollection[];
    public CustomLinkedList() {
    	mycollection = new Object[DEFAULT_CAPACITY];
        for(int i=0;i<10;i++)
        {
        	mycollection[size++] = i+1;
        }
    }
    public void add(T adding_element_in_a_list) {
        if (size == mycollection.length) {
            ensureCapacity();
        }
        mycollection[size++] = adding_element_in_a_list;
        logger.debug("The element {} is added in collection",adding_element_in_a_list);
    }
    public T remove(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        Object item = mycollection[i];
        int numElts = mycollection.length - ( i + 1 ) ;
        System.arraycopy( mycollection, i + 1, mycollection, i, numElts ) ;
        size--;
		T item2 = ((T) item);
		return item2;
    }
    
    public int size() {
        return size;
    }
    public String toString() 
    {
         StringBuilder sb = new StringBuilder();
         for(int i = 0; i < size ;i++) {
             sb.append(mycollection[i].toString());
             if(i<size-1){
                 sb.append(" ");
             }
         }
         return sb.toString();
    }
    private int validPosistion(int posistion)
	{
		if(posistion<0||posistion>=size)
		{
			return 0;
		}
		else
		{
			return 1;
		}
			
	}
    public Object fetchByPosition(int posistion)
	{
		int p=validPosistion(posistion);
		if(p==0)
		{
			logger.debug("The given posistion {} is not valid so element is not fetched",posistion);
			throw new IndexOutOfBoundsException("Index: " + posistion + ", Size " + posistion);
		}
		else
		{
			logger.debug("The element is fetched at posistion {}",posistion);
			return mycollection[posistion];
		}
	}
    
    public int insertAtPosistion(int posistion,Object value)
	{
		int p;
		p=validPosistion(posistion);
		if(p==0)
		{
			logger.debug("Invalid posistion for insertion operation");
			return -1;
		}
		for(int index=size-1;index>=posistion;index--)
			{
				mycollection[index+1]=mycollection[index];
			}
			mycollection[posistion]=value;
			size=size+1;
			logger.debug("The value {} is inserted in  posistion {}",value,posistion);
			return 1;
	}
    public int print()
	{

		logger.info("Printing of an element start");
		for(int index=0;index<size;index++)
		{
			logger.debug("Element is {} ",mycollection[index]);
		}
		logger.info("printing of an element --end--");
		return 1;
	}
    private void ensureCapacity() {
        int newSize = mycollection.length * 2;
        mycollection = Arrays.copyOf(mycollection, newSize);
    }
}
