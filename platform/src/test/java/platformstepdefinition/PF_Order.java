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
	String orderNumberLabelSTR = null;
	String thankYouPagePaymentDeadlineSTR = null;
	String thankYouPageorderNumberLabelSTR = null;

	@And("^Select 1st product from product list page$")
	public void select_1st_product_from_product_list_page() throws Throwable {
		orderObj.select1stCasecProduct();
	}

	@And("^Select 1st kanji product from product list page$")
	public void select_1st_kanji_product_from_product_list_page() throws Throwable {
		orderObj.select1stKanjiProduct();
	}

	@And("^Step 1 page proceed to next page$")
	public void step_1_page_proceed_to_next_page() throws Throwable {
		orderObj.methodForOrderFlowStep1();
	}

	@And("^Reglogin between Step 1 page to Step 2 page$")
	public void reglogin_between_step_1_page_to_step_2_page() throws Throwable {
		orderObj.methodForReloginForOrderFlow();
	}

	@And("^Step 2 page proceed to next page$")
	public void step_2_page_proceed_to_next_page() throws Throwable {
		orderObj.methodForOrderFlowStep2();
	}

	@And("^Step 3 page proceed to next page$")
	public void step_3_page_proceed_to_next_page() throws Throwable {
		orderObj.methodForOrderFlowStep3();
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

	@And("^Verify thank you page for credit card transaction$")
	public void verify_thank_you_page_for_credit_card_transaction() throws Throwable {

		String[] str_Array = orderObj.methodForCreditCardThankYouPage();
		System.out.println("Array returned from method:" + Arrays.toString(str_Array));

		orderNumberLabelSTR = str_Array[0].toString();
		log.info("Order number from thank you page,now can use to next method:- " + orderNumberLabelSTR);
	}

	@And("^Verify thank you page data on order history page for credit card transaction$")
	public void verify_thank_you_page_data_on_order_history_page_for_credit_card_transaction() throws Throwable {

		orderObj.methodForCreditCardOrderHistoryPage(orderNumberLabelSTR);

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
