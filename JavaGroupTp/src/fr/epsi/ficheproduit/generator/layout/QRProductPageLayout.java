package fr.epsi.ficheproduit.generator.layout;

import java.io.FileNotFoundException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;

import fr.epsi.ficheproduit.entity.Product;
import fr.epsi.ficheproduit.generator.layout.element.QRCard;

public class QRProductPageLayout {

	private Document document;
	private PdfContentByte canvas;

	public QRProductPageLayout(Document document, PdfContentByte canvas) { 
		this.document = document;
		this.canvas = canvas;
	}
	
	/**
	 * Creates a new {@link QRCard} with the {@link Product} data and at the specified row number.
	 * 
	 * @param product
	 * @param row
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public void addProduct(Product product, int row) throws FileNotFoundException, DocumentException {
		float yPosition = document.getPageSize().getHeight() - row * 105;
		QRCard qrCard = new QRCard(product, canvas, yPosition);
		
		document.add(qrCard.rectangle());
		document.add(qrCard.qrCode());
	}
	
	

}
