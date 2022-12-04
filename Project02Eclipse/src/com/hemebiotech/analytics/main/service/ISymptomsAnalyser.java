package com.hemebiotech.analytics.main.service;

import java.util.List;
import java.util.Map;

/**
 * Returns a Map filled with all symptoms, ordered by alphabetical order, and the number of occurrences of each, from a List of String.
 */
public interface ISymptomsAnalyser {
	
	/**
	 * Returns a Map filled with all symptoms, ordered by alphabetical order, and the number of occurrences of each, from a List of String.
	 * @param a List of String filled with all symptoms obtained from the data source (duplicates are possible/probable)
	 * @return a Map<String, Integer> filled with all symptoms (key) and the number of occurrences of each (value)
	 * @return an empty Map if no data is available 
	 */	
	Map<String, Integer> analyseSymptoms(List<String> list);
}
