import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

public class Main{
	
	public static void buildPDF(String csvLine) throws FileNotFoundException, DocumentException{
		CsvReader readCsv = new CsvReader();
		ArrayList<String> test = readCsv.csvtoArrayList(csvLine);
		PDFgenerator pdfMaker = new PDFgenerator(test);
		pdfMaker.buildDocument();
		pdfMaker.closeDocument();
	}
 
	public static void main(String args[]) throws DocumentException {
	BufferedReader buffer = null;
	    try {
			String csvLine;
			buffer = new BufferedReader(new FileReader("/Users/krm22/Documents/test.txt"));
			// How to read file in java line by line?
			while ((csvLine = buffer.readLine()) != null) {
				buildPDF(csvLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffer != null) buffer.close();
			} catch (IOException crunchifyException) {
				crunchifyException.printStackTrace();
			}
		}
	}
	
	
	
	
	
	

}
