package testng;

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

     public class ResourcesTestNG {
	 private WebDriver driver;
	 private String baseUrl;
	 private boolean acceptNextAlert = true;
	 private StringBuffer verificationErrors = new StringBuffer();
  @Test (priority = 0)
  public void CreateResourceName() {
  	/*New comment*/
	  /*Test Case 3:
	   * Verify that is possible create a resource without name*/
    driver.get(baseUrl + "/#/login");
    (new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button")));
	driver.findElement(By.xpath("//button")).click();
	(new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.linkText("Resources")));
    driver.findElement(By.linkText("Resources")).click();
    assertEquals("Resources", driver.findElement(By.linkText("Resources")).getText());
    (new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/button")));
    driver.findElement(By.xpath("//div/div/button")).click();
    (new WebDriverWait(driver,30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[4]")));
    driver.findElement(By.xpath("(//input[@type='text'])[4]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("Calidad");
    (new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.info")));
    driver.findElement(By.cssSelector("button.info")).click();
    assertEquals("Name must not be empty", driver.findElement(By.cssSelector("small.inline-error.ng-binding")).getText());   
      }
  @Test (priority = 1)
  public void  CreateResource()
  {
	  /*Test Case 4:
	   * Verify that is possible create a resource*/
    (new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-clear")));
    driver.findElement(By.cssSelector("button.btn-clear")).click();
    (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/div/button")));
    driver.findElement(By.xpath("//div/div/button")).click();
    (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[3]")));
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
    (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[3]")));
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Resource1");
    driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("Calidad");
    (new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.info")));
    driver.findElement(By.cssSelector("button.info")).click();
    assertEquals("Resource1", driver.findElement(By.xpath("//div[@id='resourcesGrid']/div[2]/div/div[2]/div[3]/div[2]/div/span")).getText());

  }
  @Test (priority = 2)
  public void CreateResourceSameName(){
	  /*Test Case 5:
	   * Verify that is possible create a resource with the same name that other one*/
    (new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/button")));
    driver.findElement(By.xpath("//div/div/button")).click();
    (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[3]")));
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
    (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[3]")));
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Resource1");
    driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
    (new WebDriverWait(driver,30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[4]")));
    driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("Calidad");
    (new WebDriverWait(driver,30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.info")));
    driver.findElement(By.cssSelector("button.info")).click();
    assertEquals("A resource with the same name already exists, please choose another name", driver.findElement(By.xpath("//small[2]")).getText());

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
