import java.util.ArrayList;

public class CsvReader {
	
	public static ArrayList<String> CsvtoArrayList(String Csv) {
		ArrayList<String> csvResult = new ArrayList<String>();
		if (Csv != null) {
			String[] splitData = Csv.split(";");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					csvResult.add(splitData[i].trim());
				}
			}
		}
		System.out.println(csvResult);
		return csvResult;
	}
}
