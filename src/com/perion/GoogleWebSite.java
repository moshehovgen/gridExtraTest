package com.perion;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleWebSite {
	private final String GOOGLE_WEB_SITE = "http://www.google.com";
	private WebDriver driver;
	public GoogleWebSite(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigate(){
		driver.get(GOOGLE_WEB_SITE);
	}
	
	public List<WebElement> searchATermAndgetResults(String term){
		List<WebElement> results = null;
		try {
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys(term);
			WebElement searchBtn = driver.findElement(By.cssSelector("input[name='btnK']"));
			searchBtn.submit();
			results = driver.findElements(By.className("g"));
		} catch (Exception e) {
			System.out.println("Exception________"+e.getMessage());
		}
		return results;
	}
	
	public void clickOnResult(WebElement result){
		result.findElement(By.tagName("a")).click();
	}

}
