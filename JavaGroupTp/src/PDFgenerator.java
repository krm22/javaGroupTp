import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

public class PDFgenerator extends ProductPageLayout {
	
	public PDFgenerator(Product product) throws FileNotFoundException, DocumentException  {
		super(product);
	}
	
	public void buildDocument() throws FileNotFoundException, DocumentException {		
		try{
					this.openDocument();
					this.rectangle();
					this.paraCode();
					this.paraCategory();
					this.paraName();
					this.paraDescriptionHeader();
					this.paraDescriptionText();
					this.paraAmountHT();
					this.paraTVA();
					this.paraTTC();
					this.closeDocument();
					
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
