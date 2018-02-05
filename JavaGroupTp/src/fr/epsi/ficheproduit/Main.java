package fr.epsi.ficheproduit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.itextpdf.text.DocumentException;

import fr.epsi.ficheproduit.entity.Product;
import fr.epsi.ficheproduit.generator.PDFGenerator;
import fr.epsi.ficheproduit.generator.layout.ProductPageLayout;
import fr.epsi.ficheproduit.generator.layout.QRProductPageLayout;
import fr.epsi.ficheproduit.reader.CsvReader;

public class Main {
	
	public static void QrCodeMain(String args[]) throws FileNotFoundException, DocumentException{
		
		PDFGenerator pdfGenerator = new PDFGenerator(new QRProductPageLayout());
	    pdfGenerator.createDocument("/Users/krm22/Downloads/generatedQRCodePdf.pdf");
	
		List<Product> products = CsvReader.csvtoArrayList(new File("/Users/krm22/Documents/test.txt"));
		pdfGenerator.render(products); 
	    pdfGenerator.saveDocument();
	}

 
	public static void ProductCodeMain(String args[]) throws DocumentException, FileNotFoundException {
		PDFGenerator pdfGenerator = new PDFGenerator(new ProductPageLayout());
	    pdfGenerator.createDocument("/Users/krm22/Downloads/generatedPdf.pdf");
		
		List<Product> products = CsvReader.csvtoArrayList(new File("/Users/krm22/Documents/test.txt"));
	    pdfGenerator.render(products);
	    pdfGenerator.saveDocument();
	}
}
