package fr.epsi.ficheproduit.generator;
import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;

import fr.epsi.ficheproduit.entity.Product;

public class ProductPageLayout  {
	
	 private Font font3 = new Font(Font.FontFamily.TIMES_ROMAN, 15);
	 private Font font4 = new Font(Font.FontFamily.TIMES_ROMAN, 27,Font.BOLD);
	 private Font font5 = new Font(Font.FontFamily.TIMES_ROMAN, 20,Font.BOLD);
	 private Product product;
	 private PdfContentByte canvas;
	    
	public ProductPageLayout(Product product, PdfContentByte canvas) throws FileNotFoundException, DocumentException {
		this.product = product;    
		this.canvas = canvas;
	}
	
	public void rectangle() throws DocumentException, FileNotFoundException {
		Rectangle rect = new Rectangle(	50, 241, 550, 600);
	    rect.setBorder(Rectangle.BOX);
	    rect.setBorderWidth(2);
	    canvas.rectangle(rect);
	}
    
	public Paragraph paraCode() throws DocumentException {
	    Paragraph code = new Paragraph();
        code.setFont(font3);
		String test = new String("Code: " + product.getProductCode());
	    System.out.println(test);
        code.add(test);
		code.setIndentationLeft(15);
		code.setSpacingAfter(100);
		code.setAlignment(Element.ALIGN_LEFT);
		
		return code;
	}
	
	public Paragraph paraCategory() throws DocumentException{
		Paragraph category = new Paragraph();
		category.setFont(font3);
		category.add("Categorie: " + product.getProductCatergory());
		category.setAlignment(Element.ALIGN_RIGHT);
		category.setIndentationRight(15);
		
		return category; 
	}
	
	public Paragraph paraName() throws DocumentException {
		Paragraph name = new Paragraph();
		name.setFont(font4);
		name.add(product.getProductName());
		name.setAlignment(Element.ALIGN_LEFT);
		name.setIndentationLeft(15);
		name.setSpacingAfter(20);
		
		return name;
	}
	
	public Paragraph paraDescriptionHeader() throws DocumentException{
		Paragraph descriptionHeader = new Paragraph();
		descriptionHeader.setFont(font3);
		descriptionHeader.add("Description");
		descriptionHeader.setAlignment(Element.ALIGN_LEFT);
		descriptionHeader.setSpacingAfter(40);
		descriptionHeader.setIndentationLeft(15);
		
		return descriptionHeader;
	}
	
	
	public Paragraph paraDescriptionText() throws DocumentException{
		Paragraph descriptionText = new Paragraph();
		descriptionText.setFont(font5);
		descriptionText.add(product.getProductDescription());
		descriptionText.setAlignment(Element.ALIGN_LEFT);
		descriptionText.setIndentationLeft(30);
		
		return descriptionText;	
	}
	
	public Paragraph paraAmountHT() throws DocumentException{
		Paragraph amount = new Paragraph();
		amount.setFont(font5);
		amount.add("Montant HT : " +  product.getProductAmountHt());
		amount.setAlignment(Element.ALIGN_RIGHT);
		amount.setIndentationRight(70);
		amount.setSpacingBefore(350);
		
		return amount;
	}
	
	public Paragraph paraTVA() throws DocumentException {
		Paragraph tax = new Paragraph();
		tax.setFont(font5);
		tax.add("TVA : " );
		tax.setAlignment(Element.ALIGN_RIGHT);
		tax.setIndentationRight(141);
		tax.setSpacingBefore(10);
		
		return tax;
	} 

	public Paragraph paraTTC() throws DocumentException {
		Paragraph ttc = new Paragraph();
		ttc.setFont(font5);
		ttc.add("Montant TTC: ");
		ttc.setAlignment(Element.ALIGN_RIGHT);
		ttc.setIndentationRight(69);
		ttc.setSpacingBefore(10);
		
		return ttc;
    }
}

