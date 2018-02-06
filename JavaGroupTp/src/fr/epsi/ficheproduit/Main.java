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
import fr.epsi.options.OptionsManager;

public class Main {
	
	public static void QrCodeMain(String args[]) throws FileNotFoundException, DocumentException{
		OptionsManager options = new OptionsManager(args);
		PDFGenerator pdfGenerator = new PDFGenerator(new QRProductPageLayout());
	    pdfGenerator.createDocument(options.getEtiquette());	    
		List<Product> products = CsvReader.csvtoArrayList(new File(options.getCsv()), options.getTva());
		pdfGenerator.render(products);
	    pdfGenerator.saveDocument();
	  
	}

 
	public static void ProductCodeMain(String args[]) throws DocumentException, FileNotFoundException {
		OptionsManager options = new OptionsManager(args);
		PDFGenerator pdfGenerator = new PDFGenerator(new ProductPageLayout());
	    pdfGenerator.createDocument(options.getFiche());
	    System.out.println(options.getFiche());
	    
		List<Product> products = CsvReader.csvtoArrayList(new File(options.getCsv()), options.getTva());
	    pdfGenerator.render(products);
	    pdfGenerator.saveDocument();
	    }
	
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		Main.QrCodeMain(args);
		Main.ProductCodeMain(args);
		
	}
}
