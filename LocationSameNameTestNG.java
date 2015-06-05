package org.room.manager.testng;

import org.testng.annotations.Test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import com.thoughtworks.selenium.webdriven.commands.WaitForCondition;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;


public class LocationSameNameTestNG {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Test (priority = 0)
	  public void testRoomManagerTestCasesAddTwoLocation() throws Exception {
		  driver.get(baseUrl + "/#/login");
		  (new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
			driver.findElement(By.xpath("//button")).click();
			(new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.linkText("Locations")));
		    driver.findElement(By.linkText("Locations")).click();
		    assertEquals("Locations", driver.findElement(By.linkText("Locations")).getText());
		    driver.findElement(By.xpath("//div[4]/div/button")).click();
		    driver.findElement(By.id("location-add-name")).clear();
		    (new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(By.id("location-add-name")));
		    driver.findElement(By.id("location-add-name")).sendKeys("New Location");
		    driver.findElement(By.id("location-add-display-name")).clear();
		    driver.findElement(By.id("location-add-display-name")).sendKeys("Location Room Manager");
		    (new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
		    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	    assertEquals("Name already exist", driver.findElement(By.xpath("//small")).getText());
	  }

	 
	  @BeforeTest
	  public void beforeMethod(){
			    driver = new FirefoxDriver();
			    baseUrl = "http://172.20.208.174:4044/admin";
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @AfterTest
	  public void afterMethod() {
		  driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      fail(verificationErrorString);
		    }
	  }
	}
