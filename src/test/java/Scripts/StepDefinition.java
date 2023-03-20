package Scripts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utitlties.Utility1;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageclasses.PageClass1;

public class StepDefinition{

	PageClass1 pc;
	WebDriverWait wait ;
	WebDriver driver;
	Actions a;
	
	@Given("^User launches the website$")
	public void launchWebSite() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(); 
		Utility1 utl=new Utility1();
		utl.enterUrl("https://www.ebay.com/",driver);
		wait = new WebDriverWait(driver,30);
		pc = new PageClass1(driver);
		a = new Actions(driver);
	}
	
	@When("^user clicks on ShopByCategory$")
	public void clickOnElement() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(pc.shopByCategory));
		pc.shopByCategory.click();
	}
	
	@And("^user clicks on \"(.*)\" under \"(.*)\" section$")
	public void clickOnCategoryUnderASection(String category, String section) {
		String xpath = "//*[text()='"+section+"']/parent::h3/following-sibling::ul//a[text()='"+category+"']";
		driver.findElement(By.xpath(xpath)).click();
		wait.until(ExpectedConditions.visibilityOf(pc.pageTitle));
		
	}
	
	@Then("^user should redirect to \"(.*)\" page$")
	public void verifyRedirection(String title) {
		Assert.assertTrue(pc.pageTitle.getText().equals(title));
	}
	
	@When("^user clicks on \"(.*)\" under Shop By Category$")
	public void clickOnALinkInShopByCategory(String category) {
		String xpath = "//*[@class='b-list__header']/following-sibling::ul//a[text()='"+category+"']";
		driver.findElement(By.xpath(xpath)).click();
		wait.until(ExpectedConditions.visibilityOf(pc.pageTitle));
	}
	
	@And("^user clicks on See All under \"(.*)\" section$")
	public void clickOnSeeAllUnderASection(String sectionName) {
		String xpath = "//h2[@class='section-title__title'][text()='"+sectionName+"']//ancestor::div[3]/following-sibling::div";
		driver.findElement(By.xpath(xpath)).click();
		wait.until(ExpectedConditions.visibilityOf(pc.seeAllPopup));
	}
	
	@And("^user selects \"(.*)\" under \"(.*)\" in the pop up$")
	public void selectOptionUnderASection(String option, String category) throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='x-overlay-aspect__label'][text()='"+category+"']")).click();
		wait.until(ExpectedConditions.visibilityOf(pc.optionsUnderASection));
		if(category.equals("Price")) {
			pc.minPrice.sendKeys(option.split(",")[0]);
			pc.maxPrice.sendKeys(option.split(",")[1]);
		}
		else if(category.equals("Screen Size"))
			driver.findElement(By.xpath("//span[@class='cbx x-refine__multi-select-cbx'][text()='"+option+"']")).click();
		else if(category.equals("Item Location"))
			driver.findElement(By.xpath("//input[@aria-label='"+option+"']")).click();
		Thread.sleep(3000);
	}
	
	@And("^user clicks on Apply button$")
	public void clickApplyButton() {
		a.click(pc.applyButton).build().perform();
		wait.until(ExpectedConditions.visibilityOf(pc.titleHavingFilters));
	}
	
	@And("^user clicks on filters selected drop down$")
	public void clickOnFiltersSelectedDropDown() {
		wait.until(ExpectedConditions.visibilityOf(pc.dropdownHavingFilters));
		a.click(pc.dropdownHavingFilters).build().perform();
	}
	
	@Then("^user verifies \"(.*)\" in filters selected$")
	public void verifyOptionUnderFiltersSelected(String optionSelected) {
		Assert.assertTrue(pc.filtersSelected.getText().contains(optionSelected));
	}
	
	@When("^user enters \"(.*)\" in the search box$")
	public void enterStringInSearchBox(String text) {
		System.out.println("&&&&&  "+System.getProperty("user.dir"));
		pc.searchBox.sendKeys(text);
	}
	
	@And("^user selects \"(.*)\" under All Categories dropdown$")
	public void selectTheOptionUnderAllCategoriesDD(String option) {
		Select s = new Select(pc.allCategoriesDropDown);
		s.selectByVisibleText("Computers/Tablets & Networking");
	}
	
	@And("^user clicks on search button$")
	public void clickOnSearchButton() throws InterruptedException {
		pc.searchButton.click();
		wait.until(ExpectedConditions.visibilityOf(pc.categoryList));
	}
	
	@Then("^user verifies the first item in the result with search item \"(.*)\"$")
	public void verifyFirstItemInResults(String searchWord) {
		Assert.assertTrue(pc.firstInCategoryList.getText().toLowerCase().contains(searchWord.toLowerCase()));
	}
	
	@And("^user closes the browser$")
	public void closeTheBrowser() {
		driver.close();
	}

}
