package Utitlties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility1 {
	WebDriver driver;
	
	public void enterUrl(String url, WebDriver driver) {
		this.driver = driver;
		driver.get(url);
	}
}
