package obj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import impl.AnalyseSymptomsFromList;
import impl.ReadSymptomDataFromFile;
import impl.WriteSymptomsInFile;
import services.ISymptomReader;
import services.ISymptomWriter;
import services.ISymptomsAnalyser;

public class AnalyticsCounter {
	
	private String filePathIn;
	private ISymptomReader symptomReader;
	private List<String> listFromFile;
	
	private ISymptomsAnalyser analyser;
	private ListSymptoms listSymptoms;
	
	private ISymptomWriter symptomWriter; 
	private String filePathOut;

	// Version initiale 
//	public AnalyticsCounter(String filePathIn, String filePathOut) {
//		this.filePathIn = filePathIn;
//		this.filePathOut = filePathOut;
//		this.symptomReader = new ReadSymptomDataFromFile(filePathIn);
//	}

	// Version modifi�e
	public AnalyticsCounter(String filePathIn, String filePathOut, ISymptomReader symptomReader, ISymptomsAnalyser analyser, ISymptomWriter symptomWriter) {
		this.filePathIn = filePathIn;
		this.filePathOut = filePathOut;
		this.symptomReader = symptomReader;
		this.analyser = analyser;
		this.symptomWriter = symptomWriter;
	}
	
	public void readFile() throws FileNotFoundException, IOException {
		this.listFromFile = symptomReader.GetSymptoms();
	}

	// Version initiale
//	public void analyseData() {		
//		this.analyser = new AnalyseSymptomsFromList(this.listFromFile);
//		this.listSymptoms = analyser.AnalyseSymptoms();
//	}
	
	// Version modifi�e
	public void analyseData() {		
		this.listSymptoms = analyser.AnalyseSymptoms(this.listFromFile);
	}

	// Version initiale
//	public void writeFile() throws FileNotFoundException, IOException {
//		this.symptomWriter = new WriteSymptomsInFile(this.filePathOut, this.listSymptoms);
//		symptomWriter.writeSymptoms();
//	}
	
	// Version modifi�e
	public void writeFile() throws FileNotFoundException, IOException {
//		this.symptomWriter = new WriteSymptomsInFile(this.filePathOut, this.listSymptoms);
		symptomWriter.writeSymptoms(this.listSymptoms);
	}

//	private static int headacheCount = 0;	
//	private static int rashCount = 0;		
//	private static int pupilCount = 0;		
//	
//	public static void main(String args[]) throws Exception {
//		
//		// first get input
//		BufferedReader breader = new BufferedReader (new FileReader("symptoms.txt"));
//		String line = breader.readLine();
//
//		while (line != null) {
//			
//			if (line.equals("headache")) {
//				headacheCount++;
//			}
//			else if (line.equals("rush")) {
//				rashCount++;
//			}
//			else if (line.contains("pupils")) {
//				pupilCount++;
//			}
//
//			line = breader.readLine();	// get another symptom
//		}
//		
//		// next generate output
//		FileWriter writer = new FileWriter ("result.out");
//		
//		writer.write("headache: " + headacheCount + "\n");
//		writer.write("rash: " + rashCount + "\n");
//		writer.write("dialated pupils: " + pupilCount + "\n");
//		
//		breader.close();
//		writer.close();
//	}
}
