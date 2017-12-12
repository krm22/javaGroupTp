import java.io.FileNotFoundException;


import java.util.ArrayList;


import com.itextpdf.text.DocumentException;



public class PDFgenerator extends ProductPageLayout  {
	
	public PDFgenerator(ArrayList<String> list) throws FileNotFoundException, DocumentException {
		super(list);
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
