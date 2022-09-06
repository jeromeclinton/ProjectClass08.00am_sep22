package org.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page extends BaseClass {

	public Page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement close;
	@FindBy(name="q")
	private WebElement search;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement clickSearch;
	@FindBy(xpath="//div[@class='_4rR01T']")
	private List<WebElement> list1;
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	private List<WebElement> priceList;
	
	public List<WebElement> getPriceList() {
		return priceList;
	}

	public List<WebElement> getList1() {
		return list1;
	}

	public WebElement getClickSearch() {
		return clickSearch;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getClose() {
		return close;
	}
}
