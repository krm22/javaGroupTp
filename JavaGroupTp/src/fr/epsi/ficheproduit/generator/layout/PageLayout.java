package fr.epsi.ficheproduit.generator.layout;

import java.io.FileNotFoundException;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;

import fr.epsi.ficheproduit.entity.Product;

public abstract class PageLayout {
	
	protected Document document;
	protected PdfContentByte canvas;
	
	/**
	 * Renders the page layout's pages with the specified products and adds them to the document.
	 * 
	 * @param products
	 * @throws DocumentException 
	 * @throws FileNotFoundException 
	 */
	public abstract void render(List<Product> products) throws FileNotFoundException, DocumentException;
	
	public void setDocument(Document document) {
		this.document = document;
	}

	public void setCanvas(PdfContentByte canvas) {
		this.canvas = canvas;
	}
}
