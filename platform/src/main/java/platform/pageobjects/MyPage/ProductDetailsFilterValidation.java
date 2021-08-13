package platform.pageobjects.MyPage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.CommonFunctions;
import utils.XLHandler;

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
	String[] shipmentdata;
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

	@FindBy(xpath = "//div[@class='select-container']")
	public WebElement productDropdown;

	@FindBy(xpath = "//span[@id='select2-type-container']")
	public WebElement productTypeDropdown;

	public void clickProductList() {
		if (CommonFunctions.waitForVisiblity(productDetails, waitTime)) {
			productDetails.click();
		}
	}

	public void CheckProductFilterFeture() throws Exception {
		shipmentdata = XLHandler.readexcel("MembershipStatus", "NewTestData.xlsx");
		freeuser = shipmentdata[0].toString();
		primeuser = shipmentdata[1].toString();
		if (freeMemberTitle.getText().contentEquals(freeuser)) {
			log.info("free user is now in membership status page");
			CheckFreeMembershipProductetails();
		} else if (primeMemberTitle.getText().contentEquals(primeuser)) {
			log.info("prime user is now in membership status page");
			CheckPrimeMembershipProductetails();
		}
	}

	public void CheckFreeMembershipProductetails() throws Exception {
		if (CommonFunctions.waitForVisiblity(productTypeDropdown, waitTime)) {
			productTypeDropdown.click();
			Select ExpiryYear = new Select(productTypeDropdown);
			ExpiryYear.selectByVisibleText("CASEC");
			log.info("Free user is Selected CASEC product");
		}

		if (CommonFunctions.waitForVisiblity(productDropdown, waitTime)) {
			productDropdown.click();
			Select ExpiryYear = new Select(productDropdown);
			ExpiryYear.selectByVisibleText("Examination");
			log.info("Free user is Selected Examination product type");
		}
	}

	public void CheckPrimeMembershipProductetails() throws Exception {
		if (CommonFunctions.waitForVisiblity(productTypeDropdown, waitTime)) {
			productTypeDropdown.click();
			Select ExpiryYear = new Select(productTypeDropdown);
			ExpiryYear.selectByVisibleText("CASEC");
			log.info("Prime user is Selected CASEC product");
		}

		if (CommonFunctions.waitForVisiblity(productDropdown, waitTime)) {
			productDropdown.click();
			Select ExpiryYear = new Select(productDropdown);
			ExpiryYear.selectByVisibleText("Examination");
			log.info("Prime user is Selected Examination product type");
		}
	}
}
