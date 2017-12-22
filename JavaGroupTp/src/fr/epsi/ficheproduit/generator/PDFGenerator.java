package fr.epsi.ficheproduit.generator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import fr.epsi.ficheproduit.entity.Product;
import fr.epsi.ficheproduit.generator.layout.ProductPageLayout;
import fr.epsi.ficheproduit.generator.layout.QRProductPageLayout;

public class PDFGenerator {

	private Document document;
	private PdfWriter writer;
	
	private int row = 0;
	
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
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds the page and it's layout to the PDF document.
	 * <b>Warning : the PDF document must be initialized with {@link #createDocument()}</b>
	 * 
	 * @param page
	 */
	public void addProduct(Product product) {		
		try{
			ProductPageLayout page = new ProductPageLayout(product, writer.getDirectContent());
			
			document.newPage();
			page.rectangle();
			document.add(page.paraCode());
			document.add(page.paraCategory());
			document.add(page.paraName());
			document.add(page.paraDescriptionHeader());
			document.add(page.paraDescriptionText());
			document.add(page.paraAmountHT());
			document.add(page.paraTVA());
			document.add(page.paraTTC());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public QRProductPageLayout addPage() {
		return new QRProductPageLayout(document, writer.getDirectContent());
	}
	
	public void addQrCard(QRProductPageLayout page, Product product){
		 try{
			page.addProduct(product, row++);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		
	}
	
	/**
	 * Saves the document.
	 */
	public void saveDocument() {
		document.close();
	}



}
