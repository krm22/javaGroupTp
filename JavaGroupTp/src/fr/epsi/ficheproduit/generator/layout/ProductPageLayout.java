package fr.epsi.ficheproduit.generator.layout;
import java.io.FileNotFoundException;
import java.util.List;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;

import fr.epsi.ficheproduit.entity.Product;

public class ProductPageLayout extends PageLayout {

	private static final Font FONT_3 = new Font(Font.FontFamily.TIMES_ROMAN, 15);
	private static final Font FONT_4 = new Font(Font.FontFamily.TIMES_ROMAN, 27,Font.BOLD);
	private static final Font FONT_5 = new Font(Font.FontFamily.TIMES_ROMAN, 20,Font.BOLD);
	
	@Override
	public void render(List<Product> products) throws FileNotFoundException, DocumentException {
		for (Product product : products) {
			document.newPage();
			rectangle();
			document.add(paraCode(product));
			document.add(paraCategory(product));
			document.add(paraName(product));
			document.add(paraDescriptionHeader());
			document.add(paraDescriptionText(product));
			document.add(paraAmountHT(product));
			document.add(paraTVA());
			document.add(paraTTC());
		}
	}

	public void rectangle() throws DocumentException, FileNotFoundException {
		Rectangle rect = new Rectangle(50, 241, 550, 600);
	    rect.setBorder(Rectangle.BOX);
	    rect.setBorderWidth(2);
	    canvas.rectangle(rect);
	    
	}   
	public Paragraph paraCode(Product product) throws DocumentException {
	    Paragraph code = new Paragraph();
        code.setFont(FONT_3);
		code.add("Code: " + product.getProductCode());
		code.setIndentationLeft(15);
		code.setSpacingAfter(100);
		code.setAlignment(Element.ALIGN_LEFT);
		
		return code;
	}
	
	public Paragraph paraCategory(Product product) throws DocumentException{
		Paragraph category = new Paragraph();
		category.setFont(FONT_3);
		category.add("Categorie: " + product.getProductCatergory());
		category.setAlignment(Element.ALIGN_RIGHT);
		category.setIndentationRight(15);
		return category; 
	}
	
	public Paragraph paraName(Product product) throws DocumentException {
		Paragraph name = new Paragraph();
		name.setFont(FONT_4);
		name.add(product.getProductName());
		name.setAlignment(Element.ALIGN_LEFT);
		name.setIndentationLeft(15);
		name.setSpacingAfter(20);
		
		return name;
	}
	
	public Paragraph paraDescriptionHeader() throws DocumentException{
		Paragraph descriptionHeader = new Paragraph();
		descriptionHeader.setFont(FONT_3);
		descriptionHeader.add("Description");
		descriptionHeader.setAlignment(Element.ALIGN_LEFT);
		descriptionHeader.setSpacingAfter(40);
		descriptionHeader.setIndentationLeft(15);
		
		return descriptionHeader;
	}
	
	
	public Paragraph paraDescriptionText(Product product) throws DocumentException{
		Paragraph descriptionText = new Paragraph();
		descriptionText.setFont(FONT_5);
		descriptionText.add(product.getProductDescription());
		descriptionText.setAlignment(Element.ALIGN_LEFT);
		descriptionText.setIndentationLeft(30);
		
		return descriptionText;	
	}
	
	public Paragraph paraAmountHT(Product product) throws DocumentException{
		Paragraph amount = new Paragraph();
		amount.setFont(FONT_5);
		amount.add("Montant HT : " +  product.getProductAmountHt());
		amount.setAlignment(Element.ALIGN_RIGHT);
		amount.setIndentationRight(70);
		amount.setSpacingBefore(350);
		
		return amount;
	}
	
	public Paragraph paraTVA() throws DocumentException {
		Paragraph tax = new Paragraph();
		tax.setFont(FONT_5);
		tax.add("TVA : " );
		tax.setAlignment(Element.ALIGN_RIGHT);
		tax.setIndentationRight(141);
		tax.setSpacingBefore(10);
		
		return tax;
	} 

	public Paragraph paraTTC() throws DocumentException {
		Paragraph ttc = new Paragraph();
		ttc.setFont(FONT_5);
		ttc.add("Montant TTC: ");
		ttc.setAlignment(Element.ALIGN_RIGHT);
		ttc.setIndentationRight(69);
		ttc.setSpacingBefore(10);
		
		return ttc;
    }
}

