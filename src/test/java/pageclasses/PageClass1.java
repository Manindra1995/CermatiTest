package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageClass1 {
	@FindBy(xpath="//button[@id='gh-shop-a']")
	public WebElement shopByCategory;
	
	public PageClass1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@class='seo-breadcrumbs-container lexexpsvc']//span)[last()]")
	public WebElement pageTitle;
	
	@FindBy(xpath="//div[@class='x-overlay__wrapper--right']")
	public WebElement seeAllPopup;
	
	@FindBy(xpath="//fieldset[@class='x-overlay-sub-panel__aspect-fieldset']")
	public WebElement optionsUnderASection;
	
	@FindBy(xpath="//button[@class='x-overlay-footer__apply-btn btn btn--primary']")
	public WebElement applyButton;
	
	@FindBy(xpath="//ul[@class='brm__list']")
	public WebElement titleHavingFilters;
	
	@FindBy(xpath="(//div[@class='x-textrange__block'])[1]/input")
	public WebElement minPrice;
	
	@FindBy(xpath="(//div[@class='x-textrange__block'])[2]/input")
	public WebElement maxPrice;
	
	@FindBy(xpath="(//ul[@class='brm__list']//button)[1]")
	public WebElement dropdownHavingFilters;
	
	@FindBy(xpath="(//ul[@class='brm__aspect-list'])[1]")
	public WebElement filtersSelected;
	
	@FindBy(xpath="//input[@class='gh-tb ui-autocomplete-input']")
	public WebElement searchBox;
	
	@FindBy(xpath="//select[@aria-label='Select a category for search']")
	public WebElement allCategoriesDropDown;
	
	@FindBy(xpath="//input[@class='btn btn-prim gh-spr']")
	public WebElement searchButton;
	
	@FindBy(xpath="//div[@id='x-refine__group__0']/ul[@class='srp-refine__category__list']")
	public WebElement categoryList;
	
	@FindBy(xpath="(//div[@class='s-item__title'])[2]/span/span")
	public WebElement firstInCategoryList;
	

	
}
