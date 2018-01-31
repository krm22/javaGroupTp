package fr.epsi.ficheproduit.generator.layout.element;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;

import fr.epsi.ficheproduit.entity.Product;

public class QRCard {
	
	public static final int WIDTH = 275;
	public static final int HEIGHT = 105;
	
	private static final int textOffsetTop = 40;
	private static final int textOffsetLeft = 90;
	//private static final int fontSize = 12;
	
	private Product product;
	private PdfContentByte canvas;
	private float xPosition;
	private float yPosition;
	
	
	/**
	 * Creates a QRCard starting at the specified (xPosition, yPosition).
	 * 
	 * @param product
	 * @param canvas
	 * @param xPosition
	 * @param yPosition
	 */
	public QRCard( Product product, PdfContentByte canvas, float xPosition, float yPosition) {
		this.product = product;
		this.canvas = canvas;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	public void rectangle() throws DocumentException, FileNotFoundException {
		Rectangle rect = new Rectangle(0,0);
	    rect.setBorder(Rectangle.BOX);
	    rect.setBorderWidth(2);
	    canvas.roundRectangle(xPosition, yPosition - HEIGHT, WIDTH, HEIGHT, 10);
	    canvas.rectangle(rect);
	    drawProductAttributes();   
	}
	
	private void drawProductAttributes() {
		float y = yPosition - textOffsetTop;
		float x = xPosition + textOffsetLeft;
		drawText(product.getProductCode(), x, y);
		drawText(product.getProductName(), x, y -= 23);
		drawText(product.getProductAmountHt() + "€ TTC", x, y -= 23);
		drawText(product.getProductAmountTTC() + "€ HT" , x += 100, y  -= 0);
	}

	public void qrCode() throws BadElementException {
		BarcodeQRCode qrcode = new BarcodeQRCode("http://test.com/", 1, 1, null);
        Image qrcodeImage = qrcode.getImage();
        qrcodeImage.setAbsolutePosition(xPosition, yPosition - HEIGHT);
        qrcodeImage.scaleAbsolute(new Rectangle(90, 90));
        try {
			canvas.addImage(qrcodeImage);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw() {
		try {
			qrCode();
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rectangle();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drawProductAttributes();
	}
	
	private void drawText(String text, float x, float y) {
		canvas.saveState();
		canvas.beginText();
		canvas.moveText(x, y);
		try {
			canvas.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED), 15);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		canvas.showText(text);
		canvas.endText();
		canvas.restoreState();
	}
	
}
