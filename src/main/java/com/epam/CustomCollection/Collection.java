package com.epam.CustomCollection;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Collection {
	private static Logger logger = LogManager.getLogger(Collection.class);
	public static void main(String args[]) {
		CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
		Scanner scan = new Scanner(System.in);
		logger.debug("Initial state:-"+list);
		logger.info("add elements to the list ");
        logger.info("How many elements do you want to add in a list : ");
       	int number_of_elements_want_to_add=scan.nextInt();
       	logger.info("Enter Elements:-");
       	for(int i=0;i < number_of_elements_want_to_add;i++) {
		int adding_element_in_a_list=scan.nextInt();
		list.add(adding_element_in_a_list);
       	}
       	logger.debug("Total list after adding elements : "+list); 
       	logger.info("insert at given posistion in the list ");
        logger.info("In which position do you want to add element : ");
       	int postition_to_add_element=scan.nextInt();
       	logger.info("Enter the element to be added in the list : ");
       	int element_to_be_added=scan.nextInt();
       	list.insertAtPosistion(postition_to_add_element, element_to_be_added);
        logger.debug("Total list after Inserting a element position :- "+list);
		logger.info("enter the index to be removed : ");
		int index_number_to_remove_element=scan.nextInt();
		list.remove(index_number_to_remove_element);
		logger.debug("Total list after removing elements : "+list);
		logger.info("Enter the position to be fetched : ");
		int fetch_position=scan.nextInt();
		logger.info("value at index 0 is "+ list.fetchByPosition(fetch_position));
		logger.info("List size : "+list.size());
		list.print();
	}
}
