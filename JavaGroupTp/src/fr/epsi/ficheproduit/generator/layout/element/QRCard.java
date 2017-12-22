package fr.epsi.ficheproduit.generator.layout.element;

import java.io.FileNotFoundException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfContentByte;

import fr.epsi.ficheproduit.entity.Product;

public class QRCard {
	
	private Product product;
	private PdfContentByte canvas;
	private float yPosition;
	
	/**
	 * Creates a QRCard starting at the specified yPosition.
	 * 
	 * @param product
	 * @param canvas
	 * @param yPosition
	 */
	public QRCard(Product product, PdfContentByte canvas, float yPosition) {
		this.product = product;
		this.canvas = canvas;
		this.yPosition = yPosition;
	}

	public Element rectangle() throws DocumentException, FileNotFoundException {
		Rectangle rect = new Rectangle(0,0);
	    rect.setBorder(Rectangle.BOX);
	    rect.setBorderWidth(2);
	    canvas.roundRectangle(10, yPosition - 105, 275, 105, 10);
	    canvas.rectangle(rect);
	    
		return rect;
	}
	
	public Image qrCode() throws BadElementException {
		BarcodeQRCode qrcode = new BarcodeQRCode("http://test.com/", 1, 1, null);
        Image qrcodeImage = qrcode.getImage();
        qrcodeImage.setAbsolutePosition(10, yPosition - 105);
        qrcodeImage.scaleAbsolute(new Rectangle(90, 90));
        
        return qrcodeImage;
	}
	
}
