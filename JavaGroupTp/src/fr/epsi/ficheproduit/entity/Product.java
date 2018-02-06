package fr.epsi.ficheproduit.entity;

public class Product {

	private String productCode;
	private String productCatergory;
	private String productName;
	private String productDescription;
	private double productAmountHt;
	private double tax = 1.2;
	


	public Product( 
			String productCode,
			String productCatergory,
			String productName,
			String productDescription,
			String productAmountHt,
			String tva){
				this.productCode = productCode;
				this.setProductCatergory(productCatergory);
				this.productName = productName;
				this.productDescription = productDescription;
				this.productAmountHt = Double.parseDouble(productAmountHt);
				this.setTax(tva);
	}

	public String getProductCode() {
		return productCode;
	}

	public String setProductCode(String productCode) {
		return this.productCode = productCode;
	}

	public String getProductCatergory() {
		return productCatergory;
	}

	public String setProductCatergory(String productCatergory) {
		return this.productCatergory = productCatergory;
	}

	public String getProductName() {
		return productName;
	}

	public String setProductName(String productName) {
		return this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public String setProductDescription(String productDescription) {
		return this.productDescription = productDescription;
	}

	public double getProductAmountHt() {
		return productAmountHt;
	}

	public void setProductAmountHt(double productAmountHt) {
		this.productAmountHt = productAmountHt;
	}
	
	public double getProductAmountTTC() {
		return this.productAmountHt * tax;
	}
	
	public String getTaxAmount(){
		double taxPaye = getProductAmountTTC() - getProductAmountHt();
		return String.format("%.2f" , taxPaye);
	}
	
	public double getTax() {
		return tax;
	}
	
	public void setTax(String taxPercent){
		double taxAdded = Double.parseDouble(taxPercent);
	    tax = taxAdded;
	}
	
	
	
 }
