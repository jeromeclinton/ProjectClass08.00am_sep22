package org.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class baseMain extends BaseClass {
	
	@BeforeClass
	private void beforeClass() {
		browserLanch("chrome");

	}
	@AfterClass
	private void afterClass() {
		quit();

	}
	
	@Test
	private void test1() {
		urlLanch("https://www.flipkart.com/");
		timeImplycity(10);
		Page p= new Page();
		click(p.getClose());
		sendKeys(p.getSearch(), "iphone 13");
		click(p.getClickSearch());
		List<WebElement> list1 = p.getList1();
		int size = list1.size();
		System.out.println("product name: ");
		for(int i=0;i<size;i++) {
			WebElement webElement = list1.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}
	}
	@Test
	private void test2() {
		urlLanch("https://www.flipkart.com/");
		timeImplycity(10);
		Page p= new Page();
		click(p.getClose());
		sendKeys(p.getSearch(), "iphone 13");
		click(p.getClickSearch());
		List<WebElement> priceList = p.getPriceList();
		int size = priceList.size();
		System.out.println("product price: ");
		for(int i=0;i<size;i++) {
			WebElement webElement = priceList.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}
	}
	@Test
	private void test3() {
		urlLanch("https://www.flipkart.com/");
		timeImplycity(10);
		Page p= new Page();
		click(p.getClose());
		sendKeys(p.getSearch(), "iphone 13");
		click(p.getClickSearch());
		List<WebElement> priceList = p.getPriceList();
		

		
		int size = priceList.size();		
		int temp=0;
		for(int i=0;i<size;i++) {
			WebElement webElement1 = priceList.get(i);
			String text = webElement1.getText();
			String replace = text.replace("₹", "");
			String replace2 = replace.replace(",", "");
			int parseInt = Integer.parseInt(replace2);
			for(int j=i+1;j<size;j++) {
				WebElement webElement2 = priceList.get(j);
				String text2 = webElement2.getText();
				String replace1 = text2.replace("₹", "");
				String replace3 = replace1.replace(",", "");
				int parseInt2 = Integer.parseInt(replace3);
				if(parseInt>parseInt2) {
					temp=parseInt;
					parseInt = parseInt2;
					parseInt2=temp;
				}
			}
		}
		System.out.println(parseInt);
		
	}
	
	@Test
	private void test4() {
		urlLanch("https://www.flipkart.com/");
		timeImplycity(10);
		Page p= new Page();
		click(p.getClose());
		sendKeys(p.getSearch(), "iphone 13");
		click(p.getClickSearch());
		List<WebElement> list1 = p.getList1();
		List<WebElement> priceList = p.getPriceList();
		Map<WebElement,WebElement> m=new HashMap<WebElement,WebElement>();
	//	m.putAll(list1,priceList);
		Set<Entry<WebElement, WebElement>> entrySet = m.entrySet();
		for (Entry<WebElement, WebElement> entry : entrySet) {
			WebElement key = entry.getKey();
			
		}
	}
	
	
	
	
	
	
	
	
	
	
}
