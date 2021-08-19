package platform.pageobjects.MyPage;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFunctions;
import utils.ExcelUtil;

public class ProductListDropdown {

	List<String[]> testdata;
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(ProductListDropdown.class.getName());
	int waitTime = 5;
	String[] shipmentdata;

	public ProductListDropdown(WebDriver driver) {
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

	public void CheckProductFilterFeature() throws Exception {

		ExcelUtil excel = new ExcelUtil();
		excel.setExcelFile("NewTestData.xlsx", "MembershipStatus");
		if (freeMemberTitle.getText().contentEquals(freeuser)) {
			productDetails.click();
			log.info("This is free user");
			CheckFreeMembership_CASEC_Productetails();
			CheckFreeMembership_kanjikentei_Productetails();
		} else if (primeMemberTitle.getText().contentEquals(primeuser)) {
			productDetails.click();
			log.info("This is prime user");
			// CheckPrimeMembership_CASEC_Productetails();
			// CheckFreeMembership_kanjikentei_Productetails();
		}
	}

	public void CheckFreeMembership_CASEC_Productetails() throws Exception {
		if (CommonFunctions.waitForVisiblity(productTypeDropdown, waitTime)) {
			ExcelUtil excel = new ExcelUtil();
			excel.setExcelFile("NewTestData.xlsx", "MembershipStatus");
			casecProduct = excel.getCellData("CASEC", 1);
			// WebElement targetDropdown = driver.findElement(By.id("order-same"));
			Select target = new Select(productDropdown);
			List<WebElement> targetListElements = target.getOptions();
			List<String> targetList = new ArrayList<String>();
			for (WebElement webElement : targetListElements) {
				targetList.add(webElement.getText());
				System.out.println(targetList.toString());
				System.out.println(targetList.equals(casecProduct));
				System.out.println(targetList.add(webElement.getText()));
				if (targetList.equals(casecProduct)) {
					Select productselect = new Select(productDropdown);
					productselect.selectByVisibleText(casecProduct);
					log.info("Free user is Selected CASEC product");
					narrowDownButton.click();
					List<WebElement> elements = driver
							.findElements(By.xpath("//div[@class='ep-product-list__row']/div"));
					for (int i = 0; i < elements.size(); i++) {
						System.out.println(i);
						System.out.println(elements.get(i).getTagName());
						System.out.println(elements.get(i).getText());
					}
				}
			}
		}
	}

	public void CheckFreeMembership_kanjikentei_Productetails() throws Exception {
		if (CommonFunctions.waitForVisiblity(productDropdown, waitTime)) {
			ExcelUtil excel = new ExcelUtil();
			excel.setExcelFile("NewTestData.xlsx", "MembershipStatus");
			kanjikenteiProduct = excel.getCellData("Kanji Kentei", 1);
			if (kanjikenteiProduct.contentEquals(productDropdown.getText())) {
				Select productselect = new Select(productDropdown);
				productselect.selectByVisibleText(kanjikenteiProduct);
				log.info("Free user is Selected kanjikentei product");
				narrowDownButton.click();
				List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ep-product-list__row']/div"));
				for (int i = 0; i < elements.size(); i++) {
					System.out.println(i);
					System.out.println(elements.get(i).getTagName());
					System.out.println(elements.get(i).getText());
				}
			}
		}
//		if (CommonFunctions.waitForVisiblity(productTypeDropdown, waitTime)) {
//			Select producttypeselect = new Select(productTypeDropdown);
//			producttypeselect.selectByVisibleText("検定受験");
//			log.info("Free user is Selected Examination product type");
//			narrowDownButton.click();
//		}
	}

	public void CheckPrimeMembershipProductetails() throws Exception {
		if (CommonFunctions.waitForVisiblity(productDropdown, waitTime)) {
			Select productselect = new Select(productDropdown);
			productselect.selectByVisibleText("CASEC");
			log.info("Prime user is Selected CASEC product");
			narrowDownButton.click();
			List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ep-product-list__row']/div"));
			for (int i = 0; i < elements.size(); i++) {
				System.out.println(i);
				System.out.println(elements.get(i).getTagName());
			}
		}
	}

	public void CheckPrimeMembershipProductetails() throws Exception {
		if (CommonFunctions.waitForVisiblity(productDropdown, waitTime)) {
			Select productselect = new Select(productDropdown);
			productselect.selectByVisibleText("CASEC");
			log.info("Prime user is Selected CASEC product");
			narrowDownButton.click();
			List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ep-product-list__row']/div"));
			for (int i = 0; i < elements.size(); i++) {
				System.out.println(i);
				System.out.println(elements.get(i).getTagName());
			}
		}
	}

	public void CheckPrimeMembershipProductetails() throws Exception {
		if (CommonFunctions.waitForVisiblity(productDropdown, waitTime)) {
			Select productselect = new Select(productDropdown);
			productselect.selectByVisibleText("CASEC");
			log.info("Prime user is Selected CASEC product");
			narrowDownButton.click();
			List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ep-product-list__row']/div"));
			for (int i = 0; i < elements.size(); i++) {
				System.out.println(i);
				System.out.println(elements.get(i).getTagName());
			}
		}
	}

}
