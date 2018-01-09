package fr.epsi.ficheproduit.generator;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerator {
	
	public static void main(String[] args) throws IOException, WriterException { 
		String content = "http://test.com";
		String filename = "/Users/krm22/Downloads/qrcode.png";
		BufferedImage image = generate(content, 40); 
		ImageIO.write(image, "PNG", new File(filename));
    }
	
	private static BufferedImage generate(String content, int sizeInPixels) throws WriterException {
		QRCodeWriter qrWriter = new QRCodeWriter();
		Object matrix = qrWriter.encode(content, BarcodeFormat.QR_CODE, sizeInPixels, sizeInPixels);
		return MatrixToImageWriter.toBufferedImage((BitMatrix) matrix);
	 }
}