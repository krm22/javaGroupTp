import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import com.itextpdf.text.Document;

public class Main{
	
	public static Document buildPDF(String csvLine){
		return PDFgenerator.buildDocument(CsvReader.CsvtoArrayList(csvLine));
	}
 
	public static void main(String args[]) {
	BufferedReader buffer = null;
	    try {
			String csvLine;
			buffer = new BufferedReader(new FileReader("/Users/krm22/Documents/test.txt"));
			// How to read file in java line by line?
			while ((csvLine = buffer.readLine()) != null) {
				buildPDF(csvLine) ;
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
