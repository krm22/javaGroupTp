package fr.epsi.ficheproduit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.itextpdf.text.DocumentException;

import fr.epsi.ficheproduit.entity.Product;
import fr.epsi.ficheproduit.generator.PDFGenerator;
import fr.epsi.ficheproduit.generator.layout.ProductPageLayout;
import fr.epsi.ficheproduit.reader.CsvReader;

public class Main {
 
	public static void main(String args[]) throws DocumentException, FileNotFoundException {
		PDFGenerator pdfGenerator = new PDFGenerator(new ProductPageLayout());
	    pdfGenerator.createDocument("/Users/krm22/Downloads/generatedPdf.pdf");
		
		List<Product> products = CsvReader.csvtoArrayList(new File("/Users/krm22/Documents/test.txt"));
	    pdfGenerator.render(products);
	    pdfGenerator.saveDocument();
	}
}
