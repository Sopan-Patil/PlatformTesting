package platformstepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import base.NewBaseClass;
import cucumber.api.junit.Cucumber;
import utils.ObjectHelper;

/**
 * @Author : Sopan patil
 * @Date : 26 Aug 2021
 * @Description: step def for Repruchase same product
 */
@RunWith(Cucumber.class)
public class PF_ProductRepurchase extends NewBaseClass {

	public WebDriver driver = ObjectHelper.driver;

}
