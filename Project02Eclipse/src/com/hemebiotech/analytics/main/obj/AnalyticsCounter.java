package com.hemebiotech.analytics.main.obj;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.main.service.ISymptomReader;
import com.hemebiotech.analytics.main.service.ISymptomWriter;
import com.hemebiotech.analytics.main.service.ISymptomsAnalyser;

/**
 * Extracts symptom data from a data source, counts the occurrences of each symptom, orders 
 * the symptoms by alphabetical order and write each symptom with its number of occurrences. 
 */
public class AnalyticsCounter {
	
	private ISymptomReader symptomReader;
	private List<String> listFromDataSource;	
	private ISymptomsAnalyser analyser;
	private Map<String, Integer> listOfSymptoms;
	private ISymptomWriter symptomWriter; 
	
	public AnalyticsCounter(ISymptomReader symptomReader, ISymptomsAnalyser analyser, ISymptomWriter symptomWriter) {
		this.symptomReader = symptomReader;
		this.analyser = analyser;
		this.symptomWriter = symptomWriter;
	}
	
	/**
	 * Extracts data from a data source and fill the attribute listFromDataSource of this class.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void readData() throws FileNotFoundException, IOException {
		this.listFromDataSource = symptomReader.getSymptoms();
	}

	/**
	 * Analyze data : fill the attribute listOfSymptoms of this class. 
	 */
	public void analyseData() {		
		this.listOfSymptoms = analyser.analyseSymptoms(this.listFromDataSource);
	}

	/**
	 * Write extracted and analyzed data.
	 * @throws IOException
	 */
	public void writeData() throws IOException {
		this.symptomWriter.writeSymptoms(listOfSymptoms);
	}
}
