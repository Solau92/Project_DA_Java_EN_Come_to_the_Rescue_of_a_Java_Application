package com.hemebiotech.analytics.main.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Reads and extracts symptoms data from a data source and returns a List of String.
 */

public interface ISymptomReader {
	/**
	 * Method that extracts symptoms from a data source and returns all the symptoms in a List of String.
	 * @return a List of String filled with all symptoms obtained from the data source (duplicates are possible/probable)
	 * @return an empty List if no data is available
	 * @throws FileNotFoundException if the file with the specified pathname does not exist or is inaccessible
	 * @throws IOException 
	 */
	List<String> getSymptoms () throws FileNotFoundException, IOException;
	
}
