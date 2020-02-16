package Selenium;
//
//@author Aarfeen
//
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
	WebDriver driver;

	@BeforeTest
	public void BeforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\SeleniumAutomation\\SeleniumSoftwares\\drivers\\New Folder\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/web-table-element.php");
		System.out.println(driver.getTitle());

	}

	@Test
	public void table() {
		List<WebElement> list1 = new ArrayList<WebElement>();
		list1 = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		int rows = list1.size();
		System.out.println(rows);

		for (int i = 1; i <= rows; i++) {

			List<WebElement> list2 = driver
					.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[" + i + "]/td"));
			System.out.println(list2.size());
			for (int j = 0; j < list2.size(); j++) {
				System.out.println(list2.get(j).getText());
			}

		}

	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
