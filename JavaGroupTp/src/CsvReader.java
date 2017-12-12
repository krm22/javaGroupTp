import java.util.ArrayList;

public class CsvReader {
	
	private String csvResult; 
	
	public String getCsvResult() {
		return this.csvResult;
	};
	
	public String setCsvResult(String csvResult) {
		return this.csvResult = csvResult;
	};

	public ArrayList<String> csvtoArrayList(String Csv) {
		ArrayList<String> csvResult = new ArrayList<String>();
		if (Csv != null) {
			String[] splitData = Csv.split(";");
			for (int i = 0; i < splitData.length; i++) {
				if ((splitData[i] != null) || !(splitData[i].length() == 0)) {
					csvResult.add(splitData[i].trim());
				}
			}
		}
		return  csvResult;
	}




}
