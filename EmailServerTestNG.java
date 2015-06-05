package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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

public class EmailServerTestNG {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	  @Test(priority = 0)
	  public void testRoomManagerTestCasesAddServer()  {
		  
		/*Test Case 1:
		 * Verify that is possible add new email Server*/
		driver.get(baseUrl + "/#/login");
		(new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
	    driver.findElement(By.xpath("//button")).click();
	    (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Email Servers")));
	    driver.findElement(By.linkText("Email Servers")).click();
	    (new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/button")));
	    driver.findElement(By.xpath("//div[2]/button")).click();
	    (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("add-mailserver-hostname")));
	    driver.findElement(By.id("add-mailserver-hostname")).clear();
	    (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("add-mailserver-hostname")));
	    driver.findElement(By.id("add-mailserver-hostname")).sendKeys("env01001.unit.com");
	    driver.findElement(By.id("add-mailserver-username")).clear();
	    driver.findElement(By.id("add-mailserver-username")).sendKeys("Administrator");
	    driver.findElement(By.id("add-mailserver-password")).clear();
	    driver.findElement(By.id("add-mailserver-password")).sendKeys("qadev02**");
	    driver.findElement(By.cssSelector("div.modal-footer.ng-scope > button.btn.btn-primary")).click();
	    (new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Email Servers")));
	    assertEquals("Email Servers", driver.findElement(By.linkText("Email Servers")).getText());
	    assertEquals("RoomManagerAdmin", driver.getTitle());
	    
	    	  }
	  
	  @Test(priority = 1)
	  public void DeleteEmailServer () 
	  {
		  /*Test Case 2:
		     * Verify that is possible delete a email server*/
		    (new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[2]")));
		    driver.findElement(By.xpath("//button[2]")).click();
		    (new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.pull-right > button.btn-clear.info")));
		    driver.findElement(By.cssSelector("div.pull-right > button.btn-clear.info")).click();
		    (new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/button")));
		    assertEquals("Add", driver.findElement(By.xpath("//div[2]/button")).getText());

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