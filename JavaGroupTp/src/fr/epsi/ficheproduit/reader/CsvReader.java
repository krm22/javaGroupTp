package fr.epsi.ficheproduit.reader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.ficheproduit.entity.Product;

public class CsvReader {
	/**
	 * Creates a list of {@link Product} from the input CSV file.
	 * 
	 * @param csv
	 * @return
	 */
	String products;
	
	public static List<Product> csvtoArrayList(File csv) {
		
		List<Product> products = new ArrayList<>();
		
		String csvLine;
		try (BufferedReader buffer = new BufferedReader(new FileReader(csv))) {
			while ((csvLine = buffer.readLine()) != null) {
				String[] splitData = csvLine.split(";");
				products.add(new Product(splitData[0], splitData[3], splitData[1], splitData[2], splitData[4]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public String getProducts(){
		return products;
	}

}
