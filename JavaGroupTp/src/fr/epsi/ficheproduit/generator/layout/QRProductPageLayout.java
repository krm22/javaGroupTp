package fr.epsi.ficheproduit.generator.layout;

import java.io.FileNotFoundException;
import java.util.List;

import com.itextpdf.text.DocumentException;

import fr.epsi.ficheproduit.entity.Product;
import fr.epsi.ficheproduit.generator.layout.element.QRCard;

public class QRProductPageLayout extends PageLayout {

	@Override
	public void render(List<Product> products) throws FileNotFoundException, DocumentException {		
		boolean alignLeft = false;

		float xPosition = 0;
		float yPosition = 0;
		
		for (int i = 0; i < products.size(); i++) {
			if (i % 16 == 0) {
				document.newPage();
			}

			if (i % 8 == 0) {
				alignLeft = !alignLeft;
				if (alignLeft) {
					xPosition = 10;
				} else {
					xPosition = document.getPageSize().getWidth() - (10 + QRCard.WIDTH);
				}
			}

			yPosition = document.getPageSize().getHeight() - (i % 8) * QRCard.HEIGHT;

			QRCard qrCard = new QRCard(products.get(i), canvas, xPosition, yPosition);

			qrCard.draw();
		}
	}
}
