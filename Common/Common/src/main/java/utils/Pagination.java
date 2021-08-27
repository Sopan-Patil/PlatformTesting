package utils;
import java.security.NoSuchProviderException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Pagination {
	/**
	 * @Author : Sopan Patil
	 * @Date : 24 Aug 2021
	 * @Description: Pagination utility
	 */
	private static Logger log = LogManager.getLogger(Pagination.class.getName());

	public void pagination() throws NoSuchProviderException {
		try {

			List<WebElement> pagination = ObjectHelper.driver.findElements(By.xpath("//div[@class='pagination']/div"));
			log.info("Total Pages " + pagination.size());
			int size = pagination.size();
			if (size > 0) {
				for (int k = 1; k <= pagination.size(); k++) {
					ObjectHelper.driver.findElement(By.xpath("//div[@class='pagination']/div[" + k + "]")).click();
				}
					
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}