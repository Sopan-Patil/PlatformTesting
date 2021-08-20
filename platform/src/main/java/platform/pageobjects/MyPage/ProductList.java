package platform.pageobjects.MyPage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;

public class ProductList {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(ProductList.class.getName());
	int waitTime = 5;
	String[] shipmentdata;

	public ProductList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='header__menu d-md-block d-none']/ul/li[4]")
	public WebElement productDetails;

	@FindBy(xpath = "//select[@id='category']")
	public WebElement testTypeDropdown;

	@FindBy(xpath = "//select[@id='type']")
	public WebElement productTypeDropdown;

	@FindBy(xpath = "//div[@class='ep-filter__button']")
	public WebElement narrowDownButton;

	@FindBy(xpath = "//a[normalize-space()='2']")
	public WebElement productListNumbers2;

	@FindBy(xpath = "//a[normalize-space()='3']")
	public WebElement productListNumbers3;

	@FindBy(xpath = "//a[normalize-space()='4']")
	public WebElement productListNumbers4;

	@FindBy(xpath = "//i[@class='icon icon-right button__icon']")
	public WebElement productListArrows;

	public void clickProductList() {
		if (CommonFunctions.waitForVisiblity(productDetails, waitTime)) {
			productDetails.click();
		}
	}

	public void clickProductDetails() throws Exception {
		CommonFunctions.scrolltoElement(productDetails);
		if (CommonFunctions.isElementClickable(productDetails)) {
			productDetails.click();
			log.info("Clicked on product list");
		}
	}

	public void CheckProductFilterFeature() throws Exception {
		CommonFunctions.scrolltoElement(narrowDownButton);
		if (CommonFunctions.isElementClickable(narrowDownButton)) {
			narrowDownButton.click();
			log.info("Clicked on narrow down button on product list page");
		}
	}

	public void checkButtonsOnProductListPage() throws Exception {
		CommonFunctions.scrolltoElement(narrowDownButton);
		CommonFunctions.isElementVisible(narrowDownButton);
		narrowDownButton.click();

	}
}
