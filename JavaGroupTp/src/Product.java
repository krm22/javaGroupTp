
import java.util.ArrayList;


public class Product {
	

	private String productCode;
	private String productCatergory;
	private String productName;
	private String productDescription;
	private String productAmountHt;

	public Product(ArrayList<String> list)  {
		this.setProductCode(list.get(0));
		this.setProductCatergory(list.get(3));
		this.setProductName(list.get(1));
		this.setProductDescription(list.get(2));
		this.setProductAmountHt(list.get(4));
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductCatergory() {
		return productCatergory;
	}

	public void setProductCatergory(String productCatergory) {
		this.productCatergory = productCatergory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductAmountHt() {
		return productAmountHt;
	}

	public void setProductAmountHt(String productAmountHt) {
		this.productAmountHt = productAmountHt;
	}
	

	
 }

