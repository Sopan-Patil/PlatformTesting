package platform.pageobjects.MyPage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.ExcelUtil;

/**
 * @Author : Sopan Patil
 * @Date : 12 Aug 2021
 * @Description:Class for Product Details
 */
public class ProductDetailsFilterValidation {
	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(ProductDetailsFilterValidation.class.getName());
	int waitTime = 5;
	String casecProduct, kanjikenteiProduct;
	String freeuser, primeuser;

	public ProductDetailsFilterValidation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='header__menu d-md-block d-none']/ul/li[4]")
	public WebElement productDetails;

	@FindBy(xpath = "//a[@class='button button--blue1 button--xsmall font-weight-normal']/span")
	public WebElement freeMemberTitle;

	@FindBy(xpath = "//a[@class='button button--blue1 button--xsmall font-weight-normal']/span")
	public WebElement primeMemberTitle;

	@FindBy(xpath = "//select[@id='category']")
	public WebElement productDropdown;

	@FindBy(xpath = "//select[@id='type']")
	public WebElement productTypeDropdown;

	@FindBy(xpath = "//div[@class='ep-filter__button']")
	public WebElement narrowDownButton;

	@FindBy(xpath = "//div[@class='ep-product-list__row']")
	public WebElement productListCard;

	public void clickProductList() {
		if (CommonFunctions.waitForVisiblity(productDetails, waitTime)) {
			productDetails.click();
		}
	}

	public void CheckingProductFilterFeature() throws Exception {

		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile("NewTestData.xlsx", "MembershipStatus");
		freeuser = excel.getCellData("Freeuser", 1);
		primeuser = excel.getCellData("Primeuser", 1);
		if (freeMemberTitle.getText().contentEquals(freeuser)) {
			productDetails.click();
			log.info("This is free user");
			CheckFreeMembership_CASEC_ProductDetails();
			CheckFreeMembershipKanjikenteiProductDetails();
		} else if (primeMemberTitle.getText().contentEquals(primeuser)) {
			productDetails.click();
			log.info("This is prime user");
			CheckPrimeMembership_CASEC_Productetails();
			CheckPrimeMembership_kanjikentei_Productetails();
		}
	}

	public void CheckFreeMembership_CASEC_ProductDetails() throws Exception {
		if (CommonFunctions.waitForVisiblity(productDropdown, waitTime)) {
//			ExcelUtil excel = new ExcelUtil();
//			excel.setExcelFile("NewTestData.xlsx", "MembershipStatus");
			casecProduct = "CASEC";
			Select target = new Select(productDropdown);
			List<WebElement> targetListElements = target.getOptions();
			int DropdownitemSize = targetListElements.size();
			for (int i = 0; i < DropdownitemSize; i++) {
				String productValue = targetListElements.get(i).getText();
				if (productValue.contains((casecProduct))) {
					Select productselect = new Select(productDropdown);
					productselect.selectByVisibleText(casecProduct);
					log.info("Free user is Selected CASEC product");
					narrowDownButton.click();
					List<WebElement> pagination = driver.findElements(By.xpath("//div[@class='pagination']/div"));
					log.info("Total Pages " + pagination.size());
					int size = pagination.size();
					if (size > 0) {
						for (int k = 1; k <= pagination.size(); k++) {
							driver.findElement(By.xpath("//div[@class='pagination']/div[" + k + "]")).click();
							List<WebElement> elements = driver
									.findElements(By.xpath("//div[@class='ep-product-list__row']/div"));
							log.info("Total cards in Page " + elements.size());
							for (int j = 0; j < elements.size(); j++) {
								if ((elements.get(j).getText()).contains(casecProduct)) {
									log.info("This is CASEC product card " + j + " Of " + elements.size()
											+ " Total Cards");
								}
							}

						}
						break;

					}
				}
			}
		} else {
			log.info("pagination not exists");
		}

	}

	public void CheckFreeMembershipKanjikenteiProductDetails() throws Exception {
		if (CommonFunctions.waitForVisiblity(productDropdown, waitTime)) {
//			ExcelUtil excel = new ExcelUtil();
//			excel.setExcelFile("NewTestData.xlsx", "MembershipStatus");
			kanjikenteiProduct = "漢検";
			Select target = new Select(productDropdown);
			List<WebElement> targetListElements = target.getOptions();
			int DropdownitemSize = targetListElements.size();
			for (int i = 0; i < DropdownitemSize; i++) {
				String productValue = targetListElements.get(i).getText();
				if (productValue.contains((kanjikenteiProduct))) {
					Select productselect = new Select(productDropdown);
					productselect.selectByVisibleText(kanjikenteiProduct);
					log.info("Free user is Selected Kanji Kaneti product");
					narrowDownButton.click();
					List<WebElement> pagination = driver.findElements(By.xpath("//div[@class='pagination']/div"));
					log.info("Total Pages " + pagination.size());
					int size = pagination.size();
					if (size > 0) {
						for (int k = 1; k <= pagination.size(); k++) {
							driver.findElement(By.xpath("//div[@class='pagination']/div[" + k + "]")).click();
							List<WebElement> elements = driver
									.findElements(By.xpath("//div[@class='ep-product-list__row']/div"));
							log.info("Total cards in Page " + elements.size());
							for (int j = 0; j < elements.size(); j++) {
								if ((elements.get(j).getText()).contains(kanjikenteiProduct)) {
									log.info("This is Kanji Kaneti product card " + j + " Of " + elements.size()
											+ " Total Cards");
								}
							}
							// break;

						}

					}
				}
			}
		} else {
			log.info("pagination not exists");
		}

	}

	public void CheckPrimeMembership_CASEC_Productetails() throws Exception {
		if (CommonFunctions.waitForVisiblity(productDropdown, waitTime)) {
//			ExcelUtil excel = new ExcelUtil();
//			excel.setExcelFile("NewTestData.xlsx", "MembershipStatus");
			casecProduct = "CASEC";
			Select target = new Select(productDropdown);
			List<WebElement> targetListElements = target.getOptions();
			int DropdownitemSize = targetListElements.size();
			for (int i = 0; i < DropdownitemSize; i++) {
				String productValue = targetListElements.get(i).getText();
				if (productValue.contains((casecProduct))) {
					Select productselect = new Select(productDropdown);
					productselect.selectByVisibleText(casecProduct);
					log.info("Prime user is Selected CASEC product");
					narrowDownButton.click();
					List<WebElement> pagination = driver.findElements(By.xpath("//div[@class='pagination']/div"));
					log.info("Total Pages " + pagination.size());
					int size = pagination.size();
					if (size > 0) {
						for (int k = 1; k <= pagination.size(); k++) {
							driver.findElement(By.xpath("//div[@class='pagination']/div[" + k + "]")).click();
							List<WebElement> elements = driver
									.findElements(By.xpath("//div[@class='ep-product-list__row']/div"));
							log.info("Total cards in Page " + elements.size());
							for (int j = 0; j < elements.size(); j++) {
								if ((elements.get(j).getText()).contains(casecProduct)) {
									log.info("This is CASEC product card " + j + " Of " + elements.size()
											+ " Total Cards");
								}
							}

						}
						break;

					}
				}
			}
		} else {
			log.info("pagination not exists");
		}

	}

	public void CheckPrimeMembership_kanjikentei_Productetails() throws Exception {
		if (CommonFunctions.waitForVisiblity(productDropdown, waitTime)) {
//			ExcelUtil excel = new ExcelUtil();
//			excel.setExcelFile("NewTestData.xlsx", "MembershipStatus");
			kanjikenteiProduct = "漢検";
			Select target = new Select(productDropdown);
			List<WebElement> targetListElements = target.getOptions();
			int DropdownitemSize = targetListElements.size();
			for (int i = 0; i < DropdownitemSize; i++) {
				String productValue = targetListElements.get(i).getText();
				if (productValue.contains((kanjikenteiProduct))) {
					Select productselect = new Select(productDropdown);
					productselect.selectByVisibleText(kanjikenteiProduct);
					log.info("Prime user is Selected Kanji Kaneti product");
					narrowDownButton.click();
					List<WebElement> pagination = driver.findElements(By.xpath("//div[@class='pagination']/div"));
					log.info("Total Pages " + pagination.size());
					int size = pagination.size();
					if (size > 0) {
						for (int k = 1; k <= pagination.size(); k++) {
							driver.findElement(By.xpath("//div[@class='pagination']/div[" + k + "]")).click();
							List<WebElement> elements = driver
									.findElements(By.xpath("//div[@class='ep-product-list__row']/div"));
							log.info("Total cards in Page " + elements.size());
							for (int j = 0; j < elements.size(); j++) {
								if ((elements.get(j).getText()).contains(kanjikenteiProduct)) {
									log.info("This is Kanji Kaneti product card " + j + " Of " + elements.size()
											+ " Total Cards");
								}
							}
							// break;

						}

					}
				}
			}
		} else {
			log.info("pagination not exists");
		}

	}

}
