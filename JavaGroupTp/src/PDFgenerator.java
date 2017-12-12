import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Rectangle;


public class PDFgenerator {
	
	private ArrayList<String> list;
	
	private Font font3 = new Font(Font.FontFamily.TIMES_ROMAN, 15);
    private Font font4 = new Font(Font.FontFamily.TIMES_ROMAN, 27,Font.BOLD);
    private Font font5 = new Font(Font.FontFamily.TIMES_ROMAN, 20,Font.BOLD);
    
    private Document document = new Document(PageSize.A4);
    private PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/Users/krm22/Downloads/generatedPdf.pdf"));
    
    
    public PDFgenerator(ArrayList<String> list) throws FileNotFoundException, DocumentException {
    	    this.list = list;
    	    document.open();
    } 
    
    
	public void rectangle() throws DocumentException, FileNotFoundException {
		PdfContentByte canvas = writer.getDirectContent();
		Rectangle rect = new Rectangle(	50, 241, 550, 600);
	    rect.setBorder(Rectangle.BOX);
	    rect.setBorderWidth(2);
	    canvas.rectangle(rect);
	}
    
	
	public void paraCode() throws DocumentException {
	    Paragraph code = new Paragraph();
        code.setFont(font3);
	    String test = new String("Code: " + list.get(0));
	    System.out.println(test);
        code.add(test);
		code.setIndentationLeft(15);
		code.setSpacingAfter(100);
		code.setAlignment(Element.ALIGN_LEFT);
		document.add(code);
	}
	
	public void paraCategory() throws DocumentException{
		Paragraph category = new Paragraph();
		category.setFont(font3);
		category.add("Catergorie: " + list.get(1));
		category.setAlignment(Element.ALIGN_RIGHT);
		category.setIndentationRight(15);
		document.add(category); 
	}
	
	public void paraName() throws DocumentException {
		Paragraph name = new Paragraph();
		name.setFont(font4);
		name.add(list.get(1));
		name.setAlignment(Element.ALIGN_LEFT);
		name.setIndentationLeft(15);
		name.setSpacingAfter(20);
		document.add(name);
	}
	
	public void paraDescription() throws DocumentException{
		Paragraph descriptionHeader = new Paragraph();
		descriptionHeader.setFont(font3);
		descriptionHeader.add("Description");
		descriptionHeader.setAlignment(Element.ALIGN_LEFT);
		descriptionHeader.setSpacingAfter(40);
		descriptionHeader.setIndentationLeft(15);
		document.add(descriptionHeader);
	}
	
	
	public void paraDescriptionHeader() throws DocumentException{
		Paragraph descriptionHeader = new Paragraph();
		descriptionHeader.setFont(font3);
		descriptionHeader.add("Description");
		descriptionHeader.setAlignment(Element.ALIGN_LEFT);
		descriptionHeader.setSpacingAfter(40);
		descriptionHeader.setIndentationLeft(15);
		document.add(descriptionHeader);
	}
	
	
	public void paraDescriptionText() throws DocumentException{
		Paragraph descriptionText = new Paragraph();
		descriptionText.setFont(font5);
		descriptionText.add(list.get(2));
		descriptionText.setAlignment(Element.ALIGN_LEFT);
		descriptionText.setIndentationLeft(30);
		document.add(descriptionText);	
	}
	
	
	public void paraAmountHT() throws DocumentException{
		Paragraph amount = new Paragraph();
		amount.setFont(font5);
		amount.add("Montant HT : " + list.get(4));
		amount.setAlignment(Element.ALIGN_RIGHT);
		amount.setIndentationRight(70);
		amount.setSpacingBefore(350);
		document.add(amount);
	}
	
	public void paraTVA () throws DocumentException {
		Paragraph tax = new Paragraph();
		tax.setFont(font5);
		tax.add("TVA : " );
		tax.setAlignment(Element.ALIGN_RIGHT);
		tax.setIndentationRight(141);
		tax.setSpacingBefore(10);
		document.add(tax);
	} 

	public void paraTTC () throws DocumentException {
		
		Paragraph ttc = new Paragraph();
		ttc.setFont(font5);
		ttc.add("Montant TTC: ");
		ttc.setAlignment(Element.ALIGN_RIGHT);
		ttc.setIndentationRight(69);
		ttc.setSpacingBefore(10);
		document.add(ttc);
	
  }
	
	public void buildDocument() throws FileNotFoundException, DocumentException {		
		try{
			
			this.rectangle();
			this.paraCode();
			this.paraCategory();
			this.paraName();
			this.paraDescription();
			this.paraDescriptionHeader();
			this.paraDescriptionText();
			this.paraAmountHT();
			this.paraTVA();
			this.paraTTC();
	
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void closeDocument() {
		document.close();
	}

}
