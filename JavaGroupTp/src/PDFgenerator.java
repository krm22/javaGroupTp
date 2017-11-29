import java.io.FileOutputStream;
//import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
/*import com.itextpdf.text.DocumentException;*/
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
/*import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;*/
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Rectangle;


public class PDFgenerator  {

	public static Document buildDocument(ArrayList<String> list) {

		Document document = new Document(PageSize.A4);
		
		try{

			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/Users/krm22/Downloads/generatedPdf.pdf"));
			document.open();
	   		
	        Font font3 = new Font(Font.FontFamily.TIMES_ROMAN, 15);
	        Font font4 = new Font(Font.FontFamily.TIMES_ROMAN, 27,Font.BOLD);
	        Font font5 = new Font(Font.FontFamily.TIMES_ROMAN, 20,Font.BOLD);
	        
	         
	        
	        Paragraph code = new Paragraph();
	        code.setFont(font3);
	        code.add("Code: " + list.get(0));
			code.setIndentationLeft(15);
			code.setSpacingAfter(100);
			code.setAlignment(Element.ALIGN_LEFT);
			document.add(code);
			
			Paragraph category = new Paragraph();
			category.setFont(font3);
			category.add("Catergorie: " + list.get(1));
			category.setAlignment(Element.ALIGN_RIGHT);
			category.setIndentationRight(15);
			document.add(category);
			
			Paragraph name = new Paragraph();
			name.setFont(font4);
			name.add(list.get(1));
			name.setAlignment(Element.ALIGN_LEFT);
			name.setIndentationLeft(15);
			name.setSpacingAfter(20);
			document.add(name);
			
			Paragraph descriptionHeader = new Paragraph();
			descriptionHeader.setFont(font3);
			descriptionHeader.add("Description");
			descriptionHeader.setAlignment(Element.ALIGN_LEFT);
			descriptionHeader.setSpacingAfter(40);
			descriptionHeader.setIndentationLeft(15);
			document.add(descriptionHeader);
			
			Paragraph descriptionText = new Paragraph();
			descriptionText.setFont(font5);
			descriptionText.add(list.get(2));
			descriptionText.setAlignment(Element.ALIGN_LEFT);
			descriptionText.setIndentationLeft(30);
			document.add(descriptionText);
			
			Paragraph amount = new Paragraph();
			amount.setFont(font5);
			amount.add("Montant HT : " + list.get(4));
			amount.setAlignment(Element.ALIGN_RIGHT);
			amount.setIndentationRight(70);
			amount.setSpacingBefore(350);
			document.add(amount);
			
			Paragraph tax = new Paragraph();
			tax.setFont(font5);
			tax.add("TVA : " );
			tax.setAlignment(Element.ALIGN_RIGHT);
			tax.setIndentationRight(141);
			tax.setSpacingBefore(10);
			document.add(tax);
			
			Paragraph ttc = new Paragraph();
			ttc.setFont(font5);
			ttc.add("Montant TTC: ");
			ttc.setAlignment(Element.ALIGN_RIGHT);
			ttc.setIndentationRight(69);
			ttc.setSpacingBefore(10);
			
			document.add(ttc);
			
			
			
		    PdfContentByte canvas = writer.getDirectContent();
			Rectangle rect = new Rectangle(	50, 241, 550, 600);
	        rect.setBorder(Rectangle.BOX);
	        rect.setBorderWidth(2);
	        canvas.rectangle(rect);
			document.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}

		return document ;
	}

}
