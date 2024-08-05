package com.delta.login1;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;


public class Utility {
	static WebDriver driver;
	WebDriverWait wait; 
	public static WebDriver getDriver(){
		//Configure the driver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashrkhan\\eclipse-workspace\\FitPeo\\driver\\chromedriver.exe");
				
		//Launch the browser
		driver = new ChromeDriver(options);
		
		return driver;
	}
	
      public static void getUrl(String url) {
    	  driver.get(url);
    	  maximize();
      }
      
	   public static void maximize() {
	        driver.manage().window().maximize();
	    }
	    
	     public static void type(WebElement element, String data) {
	        element.sendKeys(data);
	      }
	     
	     public static void btnClick(WebElement element) {
	        element.click();
	      }
	      
	     public static void quit() {
	        driver.quit();
	     }
	     
	    public static void typeJs(WebElement element, String data) {
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("arguments[0].setAttribute('value' " + data +")", element);
	    }
	    
	    public static void btnClick3 (WebElement element) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].click", element);
	    }
	    
	    public static String getValueByText(WebElement element) {
	        return element.getText();
	    }
	      
	    public static String getAttributeValue(WebElement element) {
	        return element.getAttribute("value");
	    }
	    
		  
		 public static void closeBrowser() {
		    driver.quit();
		 }
		 
		 public static void closeWindow() {
			    driver.close();
			}
		 
		
		public static void implicitWait(int seconds) {	
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		}
		
		public static void explicittWaitUrlContains(int seconds, String str) {	
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			 wait.until(ExpectedConditions.urlContains(str));
		}
		
		public static void explicittWaitUrlPresenceElem(int seconds, By locator) {	
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			 wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		
		public static void switchToFrame(WebElement element) {	
			driver.switchTo().frame(element);
		}
		
		public static void switchToDefaultContent() {	
			driver.switchTo().defaultContent();
		}
		
		public static void sendKeysRight() {	
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ARROW_RIGHT).perform();
		}
		
		public static void clearTextField(WebElement element) {	
			 element.sendKeys(Keys.CONTROL + "a");
			 element.sendKeys(Keys.DELETE);
		}
		
		
		public static void scrollDownElem(WebElement element) {	
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		
		public static void scrollDown(int value) {	
		     JavascriptExecutor js = (JavascriptExecutor) driver;
		     js.executeScript("window.scrollBy(0,"+ value +" );");
		}
		
		
		public static void selectCheckbox(WebElement webelement) {
	        WebElement checkbox = webelement;
	        if (!checkbox.isSelected()) {
	            checkbox.click();
	        }
	    }
		
		public static boolean isCheckboxSelected(WebElement webelement) {
	        WebElement checkbox = webelement;
	        return checkbox.isSelected();
	    }
		

		public static boolean isElementPresent(WebElement element) {	
			 try
			    {
			        return true;
			    }
			    catch(NoSuchElementException e)
			    {           
			        e.printStackTrace();
			        return false;  
			    }
			         
		}

}
