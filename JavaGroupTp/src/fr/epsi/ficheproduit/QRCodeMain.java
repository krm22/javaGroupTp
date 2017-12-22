package fr.epsi.ficheproduit;

import java.io.File;
import java.util.List;

import fr.epsi.ficheproduit.entity.Product;
import fr.epsi.ficheproduit.generator.PDFGenerator;
import fr.epsi.ficheproduit.generator.layout.QRProductPageLayout;
import fr.epsi.ficheproduit.reader.CsvReader;

public class QRCodeMain {
	
	public static void main(String args[]){
		
		PDFGenerator pdfGenerator = new PDFGenerator();
	    pdfGenerator.createDocument("/Users/krm22/Downloads/generatedQRCodePdf.pdf");
		
	    QRProductPageLayout page = pdfGenerator.addPage();
	    
		List<Product> products = CsvReader.csvtoArrayList(new File("/Users/krm22/Documents/test.txt"));
	    for (Product product : products) {
	    		pdfGenerator.addQrCard(page, product);
	    }
	    pdfGenerator.saveDocument();
	}

}
