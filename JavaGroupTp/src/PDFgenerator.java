import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class PDFgenerator {
	public static final String chemin = "/Users/krm22/Documents/javaGroupTp.pdf";
	
public static void main(String[] args) throws DocumentException, IOException

{
	Document document = new Document();
	
	try
	{
		PdfWriter.getInstance(document,  new FileOutputStream(chemin));
		
		document.open();
		
		//ajout du contenu
		
		document.add(new Paragraph("TEST generation du pdf"));
		document.add(premierTableau());
		
	}catch (DocumentException de)
	{
		de.printStackTrace();
	}catch (IOException ioe)
	{
		ioe.printStackTrace();
	}
	//fermeture du document
	
	document.close();
}

//Classe qui permet de dessiner un tableau

public static PdfPTable premierTableau()
{
	//On créer un objet table dans lequel on intialise ça taille
	PdfPTable table = new PdfPTable(3);
	//On créer l'objet cellule.
    PdfPCell cell;
    
    cell = new PdfPCell(new Phrase("Fusion de chaque première cellule de chaque colonne"));
    cell.setColspan(3);
    table.addCell(cell);

    cell = new PdfPCell(new Phrase("Fusion de 2 cellules de la première colonne"));
    cell.setRowspan(2);
    table.addCell(cell);

    //contenu du tableau.
    table.addCell("Colonne 1; Cellule 1");
    table.addCell("Colonne 1; Cellule 2");
    table.addCell("Colonne 2; Cellule 1");
    table.addCell("Colonne 2; Cellule 2");
    
    return table;  
}

}
