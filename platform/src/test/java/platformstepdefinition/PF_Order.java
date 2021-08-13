package platformstepdefinition;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import platform.pageobjects.Order.Order;
import utils.ObjectHelper;

@RunWith(Cucumber.class)
public class PF_Order extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;
	private static Logger log = LogManager.getLogger(PF_Order.class.getName());
	String emailid = "";
	Order orderObj = new Order(driver);
	NewBaseClass baseClassObj = new NewBaseClass();
	String orderNumberLabelSTR = null;
	String thankYouPagePaymentDeadlineSTR = null;
	String thankYouPageorderNumberLabelSTR = null;
	String productNameFromProductListPage = null;
	String productPriceFromProductListPage = null;

	@And("^Select 1st product from product list page$")
	public void select_1st_product_from_product_list_page() throws Throwable {
		orderObj.select1stCasecProduct();

		String[] str_Array = orderObj.select1stCasecProduct();
		System.out.println("Array returned from method:" + Arrays.toString(str_Array));

		productNameFromProductListPage = str_Array[0].toString();
		log.info("Product name from product list page:- " + productNameFromProductListPage);

		productPriceFromProductListPage = str_Array[1].toString();
		log.info("Product price from product list page:- " + productPriceFromProductListPage);

	}

	@And("^Select 1st kanji product from product list page$")
	public void select_1st_kanji_product_from_product_list_page() throws Throwable {
		orderObj.select1stKanjiProduct();
	}

	@And("^Step 1 page proceed to next page$")
	public void step_1_page_proceed_to_next_page() throws Throwable {
		orderObj.methodForOrderFlowStep1(productNameFromProductListPage, productPriceFromProductListPage);
	}

	@And("^Step 2 page proceed to next page$")
	public void step_2_page_proceed_to_next_page() throws Throwable {
		orderObj.methodForOrderFlowStep2(productNameFromProductListPage, productPriceFromProductListPage);
	}

	@And("^Step 3 page proceed to next page$")
	public void step_3_page_proceed_to_next_page() throws Throwable {
		orderObj.methodForOrderFlowStep3(productNameFromProductListPage, productPriceFromProductListPage);
	}

	@And("^Open Product List Page$")
	public void open_product_list_page() throws Throwable {
		orderObj.openProductListPage();
	}

	@And("^Click on back button from order flow$")
	public void click_on_back_button_from_order_flow() throws Throwable {
		orderObj.clickOnOrderFlowBackButton();
	}

	@And("^Open MemberShip Plan Page from Top page$")
	public void open_membership_plan_page_from_top_page() throws Throwable {
		orderObj.openMemberPlanPageFromTopPage();
	}

	@And("^Apply MemberShip Plan from Top page$")
	public void apply_membership_plan_from_top_page() throws Throwable {
		orderObj.clickApplyForPrimeMembershipButton();
	}

	@And("^Confirm Order Flow Step 1 Page Load Successfully$")
	public void confirm_order_flow_step_1_page_load_successfully() throws Throwable {
		orderObj.orderFlowStep1PageLoadedSuccessfully();
	}

	@And("^Confirm Order Flow Step 2 Page Load Successfully$")
	public void confirm_order_flow_step_2_page_load_successfully() throws Throwable {
		orderObj.orderFlowStep2PageLoadedSuccessfully();
	}

	@And("^Confirm Order Flow Step 3 Page Load Successfully$")
	public void confirm_order_flow_step_3_page_load_successfully() throws Throwable {
		orderObj.orderFlowStep3PageLoadedSuccessfully();
	}

	@And("^Confirm Order Flow Step 4 thank you Page Load Successfully$")
	public void confirm_order_flow_step_4_thank_you_page_load_successfully() throws Throwable {
		orderObj.orderFlowStep4ThankYouPageLoadedSuccessfully();
	}

	@And("^Proceeed With 1st Casec Product$")
	public void proceeed_with_1st_casec_product() throws Throwable {
		orderObj.proceedWith1stCasecProduct();
	}

	@And("^Reglogin between Step 1 page to Step 2 page$")
	public void reglogin_between_step_1_page_to_step_2_page() throws Throwable {
		orderObj.methodForReloginForOrderFlow();
	}

	@And("^Step 2 Payment With Valid Credit Card$")
	public void step2_payment_with_valid_credit_card() throws Throwable {
		orderObj.methodForStep2PaymentWithValidCreditCard();
	}

	@And("^Step 2 Payment With Blank Credit Card$")
	public void step2_payment_with_blank_credit_card() throws Throwable {
		orderObj.methodForStep2PaymentWithBlankCreditCard();
	}

	@And("^Step 2 Payment With InValid Credit Card$")
	public void step_2_payment_with_invalid_credit_card() throws Throwable {
		orderObj.methodForStep2PaymentWithInValidCreditCard();
	}

	@And("^Step 2 Payment With Valid Convenience Store$")
	public void step2_payment_with_valid_convenience_store() throws Throwable {
		orderObj.methodForStep2PaymentWithConStore();
	}

	@And("^Step 2 Payment With InValid Convenience Store$")
	public void step_2_payment_with_invalid_convenience_store() throws Throwable {
		orderObj.step2PaymentWithInValidConStore();
	}

	@And("^Step 2 Payment With Blank Con Store$")
	public void step_2_payment_with_blank_con_store() throws Throwable {
		orderObj.step2PaymentWithBlankConStore();
	}

	@And("^Refresh page$")
	public void refresh_page() throws Throwable {
		baseClassObj.refreshbrowser();
	}

	@And("^Verify thank you page for credit card transaction$")
	public void verify_thank_you_page_for_credit_card_transaction() throws Throwable {

		String[] str_Array = orderObj.methodForCreditCardThankYouPage();
		System.out.println("Array returned from method:" + Arrays.toString(str_Array));

		orderNumberLabelSTR = str_Array[0].toString();
		log.info("Order number from thank you page,now can use to next method:- " + orderNumberLabelSTR);
	}

	@And("^Verify thank you page for prime transaction$")
	public void verify_thank_you_page_for_prime_transaction() throws Throwable {

		String[] str_Array = orderObj.methodForPrimeThankYouPage();
		System.out.println("Array returned from method:" + Arrays.toString(str_Array));

		orderNumberLabelSTR = str_Array[0].toString();
		log.info("Order number from prime thank you page,now can use to next method:- " + orderNumberLabelSTR);
	}

	@And("^Verify thank you page data on order history page for credit card transaction$")
	public void verify_thank_you_page_data_on_order_history_page_for_credit_card_transaction() throws Throwable {

		orderObj.methodForCreditCardOrderHistoryPage(orderNumberLabelSTR);

	}

	@And("^Verify thank you page data on order history page for prime transaction$")
	public void verify_thank_you_page_data_on_order_history_page_for_prime_transaction() throws Throwable {

		orderObj.methodForPrimeOrderHistoryPage(orderNumberLabelSTR);

	}

	@And("^Verify Service you are using page for prime transaction$")
	public void verify_service_you_are_using_page_for_prime_transaction() throws Throwable {

		orderObj.verifyServiceYouAreUsingPageForPrime();

	}

	@And("^Verify Membership status page for prime transaction$")
	public void verify_membership_status_page_for_prime_transaction() throws Throwable {

		orderObj.verifyMembershipStatusPageForPrime();

	}

	@And("^Verify thank you page for convenience store transaction$")
	public void verify_thank_you_page_for_convenience_store_transaction() throws Throwable {

		String[] str_Array = orderObj.methodForConStoreThankYouPage();
		System.out.println("Array returned from method:" + Arrays.toString(str_Array));

		thankYouPagePaymentDeadlineSTR = str_Array[0].toString();
		log.info("Payment dead line date from thank you page,now can use to next method:- "
				+ thankYouPagePaymentDeadlineSTR);

		thankYouPageorderNumberLabelSTR = str_Array[1].toString();
		log.info("Order number from thank you page,now can use to next method:-  " + thankYouPageorderNumberLabelSTR);

	}

	@And("^Verify thank you page data on order history page for convenience store transaction$")
	public void verify_thank_you_page_data_on_order_history_page_for_convenience_store_transaction() throws Throwable {

		orderObj.methodForConStoreOrderHistoryPage(thankYouPagePaymentDeadlineSTR, thankYouPageorderNumberLabelSTR);

	}

	@And("^Verify learn button from Service you are using page$")
	public void verify_learn_button_from_service_you_are_using_page() throws Throwable {
		orderObj.verifyLearnButtonFromServiceYouAreUsingPage();
	}
}
