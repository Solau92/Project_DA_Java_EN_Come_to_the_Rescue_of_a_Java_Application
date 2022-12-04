package com.hemebiotech.analytics.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.hemebiotech.analytics.main.obj.AnalyticsCounter;
import com.hemebiotech.analytics.main.service.impl.AnalyseSymptomsFromList;
import com.hemebiotech.analytics.main.service.impl.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.main.service.impl.WriteSymptomsInFile;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String filePathIn = "./resources/symptoms.txt";
		String filePathOut = "./resources/result.out";
		
		AnalyticsCounter analysis = new AnalyticsCounter(new ReadSymptomDataFromFile(filePathIn), new AnalyseSymptomsFromList(),
				new WriteSymptomsInFile(filePathOut));
		analysis.readData();
		analysis.analyseData();
		analysis.writeData();

	}

}
