package com.hemebiotech.analytics.main.service.impl;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.hemebiotech.analytics.main.service.ISymptomWriter;

/**
 * Writes symptoms data in a file.
 */
public class WriteSymptomsInFile implements ISymptomWriter {
	
	private String filePathOut;

	public WriteSymptomsInFile(String filePath) {
		this.filePathOut = filePath;
	}

	/**
	 * Writes in a file data recorded in a Map<String, Integer>.
	 * @param Map<String, Integer> listOfSymptoms
	 * @throws IOException if the file does not exist and cannot be created, 
	 * or exists but cannot be opened for any other reason
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> listSymptomsAndOccurrence) throws IOException {

		FileWriter fwriter = new FileWriter(this.filePathOut);
		
		for (String s : listSymptomsAndOccurrence.keySet()) {
			
			String line = s + " : " + listSymptomsAndOccurrence.get(s) + "\n";
			fwriter.write(line);
		}
		
		fwriter.close();
	}
}
