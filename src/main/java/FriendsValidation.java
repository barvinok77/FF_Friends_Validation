import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FriendsValidation {

	public static void main(String[] args) {

		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		String url = "http://www.facebook.com";
		String n_friends_expected = "67";

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		// String title_actual= driver.getTitle();
		// String copyright_actual =
		// driver.findElement(By.xpath("//div[3]/div/span")).getText();
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.cssSelector("input[value='Log In']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[@title='Профиль']"))).click();
		String n_friends_actual = driver.findElement(By.xpath("//a[@data-tab-key='friends']/span[@class='_gs6']")).getText();
		driver.findElement(By.id("userNavigationLabel")).click();
		driver.findElement(By.cssSelector("a[data-gt*='menu_logout']")).click();
		driver.quit();

		if (n_friends_expected.equals(n_friends_actual)) {
			System.out.println("Test Case ID:\t\tTC-01.01.01");
			System.out.println("Test Case Resul:\t" + "PASSED");
		} else {
			System.out.println("Test Case ID:\t\tTC-01.01.01");
			System.out.println("Test Case Resul:\t" + "FAILED");
		}
	}
}
