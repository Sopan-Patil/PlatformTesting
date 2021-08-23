package platform.pageobjects.MyPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	@FindBy(xpath = "//div[@class='ep-filter__button']")
	public WebElement narrowDownButton;

	@FindBy(xpath = "//a[normalize-space()='2']")
	public WebElement productListNumbers2;

	@FindBy(xpath = "//a[normalize-space()='3']")
	public WebElement productListNumbers3;

	@FindBy(xpath = "//a[normalize-space()='4']")
	public WebElement productListNumbers4;

	@FindBy(xpath = "//i[@class='icon icon-left button__icon']")
	public WebElement productListArrowLeft;

	@FindBy(xpath = "//i[@class='icon icon-right button__icon']")
	public WebElement productListArrowRight;

	@FindBy(xpath = "//a[normalize-space()='1']")
	public WebElement productListArrow1;

	@FindBy(xpath = "//select[@id='category']")
	public WebElement testTypeDropdown;

	@FindBy(xpath = "//select[@id='type']")
	public WebElement productTypeDropdown;

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

	public void checkButtonsOnProductListPage() throws Exception {	
		CommonFunctions.scrolltoElement(narrowDownButton);
		CommonFunctions.isElementVisible(narrowDownButton);
		narrowDownButton.click();
		CommonFunctions.isElementVisible(productListNumbers2);
		if (CommonFunctions.waitForVisiblity(productListNumbers2, waitTime)) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			productListNumbers2.click();
			log.info("Clicked on product list 2");
		} else {
			log.error("product list 2 button not working");
		}
	}
	
		
	
	public void CheckProductFilterFeature() throws Exception {
		CommonFunctions.scrolltoElement(narrowDownButton);
		if (CommonFunctions.isElementClickable(narrowDownButton)) {
			narrowDownButton.click();
			log.info("Clicked on narrow down button on product list page");
		}
		CommonFunctions.scrolltoElement(productListNumbers2);
		if (CommonFunctions.isElementClickable(productListNumbers2)) {
			productListNumbers2.click();
			log.info("Clicked on product list 2");
		}
		CommonFunctions.scrolltoElement(productListNumbers3);
		if (CommonFunctions.isElementClickable(productListNumbers3)) {
			productListNumbers3.click();
			log.info("Clicked on product list 3");
		}
		CommonFunctions.scrolltoElement(productListNumbers4);
		if (CommonFunctions.isElementClickable(productListNumbers4)) {
			productListNumbers4.click();
			log.info("Clicked on product list 4");
		}
		CommonFunctions.scrolltoElement(productListArrowLeft);
		if (CommonFunctions.isElementClickable(productListArrowLeft)) {
			productListArrowLeft.click();
			log.info("Clicked on left arrow on product list page");
		}
		CommonFunctions.scrolltoElement(productListArrowRight);
		if (CommonFunctions.isElementClickable(productListArrowRight)) {
			productListArrowRight.click();
			log.info("Clicked on right arrow on product list page");
		}
		CommonFunctions.scrolltoElement(productListArrow1);
		if (CommonFunctions.isElementClickable(productListArrow1)) {
			productListArrow1.click();
			log.info("Clicked on product list 1");
		}
	}

	
		
		
		CommonFunctions.scrolltoElement(productListNumbers2);
		CommonFunctions.isElementVisible(productListNumbers2);
		productListNumbers2.click();
		CommonFunctions.scrolltoElement(productListNumbers3);
		CommonFunctions.isElementVisible(productListNumbers3);
		productListNumbers3.click();
		CommonFunctions.scrolltoElement(productListNumbers4);
		CommonFunctions.isElementVisible(productListNumbers4);
		productListNumbers4.click();
		CommonFunctions.scrolltoElement(productListArrowLeft);
		CommonFunctions.isElementVisible(productListArrowLeft);
		productListArrowLeft.click();
		CommonFunctions.scrolltoElement(productListArrowRight);
		CommonFunctions.isElementVisible(productListArrowRight);
		productListArrowRight.click();
		CommonFunctions.scrolltoElement(productListArrow1);
		CommonFunctions.isElementVisible(productListArrow1);
		productListArrow1.click();
	}}
