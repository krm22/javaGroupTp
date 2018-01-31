package fr.epsi.ficheproduit.generator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import fr.epsi.ficheproduit.entity.Product;
import fr.epsi.ficheproduit.generator.layout.PageLayout;

public class PDFGenerator {

	private Document document;
	private PdfWriter writer;
	private PageLayout pageLayout;
	
	public PDFGenerator(PageLayout pageLayout) {
		this.pageLayout = pageLayout;
	}
	
	/**
	 * Initializes an empty PDF document with the specified file path.
	 * 
	 * @param filePath
	 */
	public void createDocument(String filePath) {
		document = new Document(PageSize.A4);
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			pageLayout.setDocument(document);
			pageLayout.setCanvas(writer.getDirectContent());
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void render(List<Product> products) throws FileNotFoundException, DocumentException {
		pageLayout.render(products);
	}
	
	/**
	 * Saves the document.
	 * 
	 * @throws DocumentException 
	 * @throws FileNotFoundException 
	 */
	
	public void saveDocument() throws FileNotFoundException, DocumentException {		
		document.close();
	}



}
