package com.hemebiotech.analytics.main.service;

import java.io.IOException;
import java.util.Map;

/**
 * Writes symptoms data.
 */
public interface ISymptomWriter {

	/**
	 * Writes symptoms data recorded in a Map<String, Integer>.
	 * @param Map<String, Integer> listOfSymptoms
	 * @throws IOException if the file does not exist and cannot be created, 
	 * or exists but cannot be opened for any other reason
	 */
	void writeSymptoms(Map<String, Integer> listOfSymptoms) throws IOException;
}
