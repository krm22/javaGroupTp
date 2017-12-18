package fr.epsi.ficheproduit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.itextpdf.text.DocumentException;

import fr.epsi.ficheproduit.entity.Product;
import fr.epsi.ficheproduit.generator.PDFGenerator;
import fr.epsi.ficheproduit.reader.CsvReader;

public class Main {
 
	public static void main(String args[]) throws DocumentException, FileNotFoundException {
		PDFGenerator pdfGenerator = new PDFGenerator();
	    pdfGenerator.createDocument("/Users/krm22/Downloads/generatedPdf.pdf");
		
		List<Product> products = CsvReader.csvtoArrayList(new File("/Users/krm22/Documents/test.txt"));
	    for (Product product : products) {
	    		pdfGenerator.addProduct(product);
	    }
	    
	    pdfGenerator.saveDocument();
	}
	
}
