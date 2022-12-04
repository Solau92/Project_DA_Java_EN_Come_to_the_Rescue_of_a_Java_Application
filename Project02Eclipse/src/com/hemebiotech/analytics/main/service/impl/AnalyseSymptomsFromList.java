package com.hemebiotech.analytics.main.service.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.analytics.main.service.ISymptomsAnalyser;

/**
 * Returns a Map filled with all symptoms, ordered by alphabetical order, and the number of occurrences of each, from a List of String.
 */
public class AnalyseSymptomsFromList implements ISymptomsAnalyser {

	/**
	 * Returns a Map filled with all symptoms and the number of occurrences of each, from a List of String.
	 * @param a List of String filled with all symptoms obtained from the data source (duplicates are possible/probable)
	 * @return a Map<String, Integer> filled with all symptoms (key) and the number of occurrences of each (value)
	 * @return an empty Map if no data is available 
	 */	
	@Override
	public Map<String, Integer> analyseSymptoms(List<String> listSymptomsString) {

		Map<String, Integer> listSymptomsAndOccurrence = new TreeMap<String, Integer>();

		for (String s : listSymptomsString) {

			if (listSymptomsAndOccurrence.isEmpty()) {
				listSymptomsAndOccurrence.put(s, 1);
			} else {

				if (listSymptomsAndOccurrence.containsKey(s)) {
					listSymptomsAndOccurrence.replace(s, (listSymptomsAndOccurrence.get(s) + 1));
				} else {
					listSymptomsAndOccurrence.put(s, 1);
				}
			}
		}
		return listSymptomsAndOccurrence;

	}

}
