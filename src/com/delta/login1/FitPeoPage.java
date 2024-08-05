package com.delta.login1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.delta.login1.Utility;

public class FitPeoPage extends Utility{ 
	public FitPeoPage() {
		PageFactory.initElements(driver,this);
	}
	
	@CacheLookup
	@FindBy(linkText="Revenue Calculator")
	private WebElement revenueCalculatorLink;
	
	@FindBy(xpath="//div[contains(@class, 'MuiGrid-root') and contains(@class, 'MuiGrid-container')]")
	private WebElement sliderSection;
	
	@FindBy(xpath="//iframe[@title='Close message']")
	private WebElement iframe1;
	
	@FindBy(xpath="//button[@aria-label='Close message from company']")
	private WebElement chatBotCloseBtn1;
	
	@FindBy(xpath="//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-sy3s50']")
	private WebElement slider;
	
	@FindBy(xpath="//input[@type='range']")
	private WebElement slider1;
	
	@FindBy(id=":r0:")
	private WebElement textField;
	
	@FindBy(xpath="//p[contains(text(), 'CPT-99091')]/parent::div//input[@class='PrivateSwitchBase-input css-1m9pwf3']")
	private WebElement cpt99091;
	
	@FindBy(xpath="//p[contains(text(), 'CPT-99453')]/parent::div//input[@class='PrivateSwitchBase-input css-1m9pwf3']")
	private WebElement cpt99453;
	
	@FindBy(xpath="//p[contains(text(), 'CPT-99454')]/parent::div//input[@class='PrivateSwitchBase-input css-1m9pwf3']")
	private WebElement cpt99454;
	
	@FindBy(xpath="//p[contains(text(), 'CPT-99474')]/parent::div//input[@class='PrivateSwitchBase-input css-1m9pwf3']")
	private WebElement cpt99474;
	
	@FindBy(xpath="//p[contains(text(), 'Total Recurring Reimbursement for all Patients Per Month:')]/child::p[@class='MuiTypography-root MuiTypography-body1 inter css-hocx5c']")
	private WebElement reimbursementHeader;
	
	By iframe = By.xpath("//iframe[@title='Close message']");
	
	By chatBotCloseBtn = By.xpath("//button[@aria-label='Close message from company']");
	
	public WebElement getrevenueCalculatorLink() {
		return revenueCalculatorLink;
	}
	
	public WebElement getSliderSection() {
		return sliderSection;
	}
	
	public WebElement getFrame1() {
		return iframe1;
	}
	
	public WebElement getChatBotCloseBtn1() {
		return chatBotCloseBtn1;
	}
	
	public WebElement getSlider() {
		return slider;
	}
	
	public WebElement getTextField() {
		return textField;
	}
	
	public WebElement getCpt99091() {
		return cpt99091;
	}
	
	public WebElement getCpt99454() {
		return cpt99454;
	}
	
	public WebElement getCpt99474() {
		return cpt99474;
	}
	
	public WebElement getCpt99453() {
		return cpt99453;
	}
	
	public WebElement getSlider1() {
		return slider1;
	}
	
	public WebElement getReimbursementHeader() {
		return reimbursementHeader;
	}
	
	public void adjustSlider() {
	    // Focus on the slider to ensure key events are registered
		btnClick(getSlider());
	    int adjustValue = 197;
	    int desiredValue = 820;
	    int maxValue = 2000;
	    // Loop to increment the slider value
	    while (adjustValue <= desiredValue && adjustValue < maxValue) {
	    	sendKeysRight(); // Increment the slider
			adjustValue++;
	    }
	}
	
	public void verifyTextField(String desiredValue) throws InterruptedException {   
	    if (getAttributeValue(getTextField()).equals(String.valueOf(desiredValue))) {
	        System.out.println("Slider value successfully set to " + getAttributeValue(getTextField()) + ".");
	        Thread.sleep(10);
	    } else {
	        System.out.println("Failed to set slider value. Current value: " + getAttributeValue(getTextField()));
	        Thread.sleep(10);
	    }
	}
	
	public void verifySlider(String desiredValue) throws InterruptedException {   
		String sliderValue = getAttributeValue(getSlider1());
	    if (sliderValue.equals(desiredValue)) {
	        System.out.println("Slider value successfully set to " + sliderValue + ".");
	    } else {
	        System.out.println("Failed to set slider value. Current slider value: " + sliderValue);
	    }
	}
	
	public void verifyCheckboxSelected() throws InterruptedException {  
		if (isCheckboxSelected(getCpt99091()) &&
	            isCheckboxSelected(getCpt99453()) &&
	            isCheckboxSelected(getCpt99454()) &&
	            isCheckboxSelected(getCpt99474())) {
	            System.out.println("CPT codes successfully selected.");
	        } else {
	            System.out.println("Failed to select some CPT codes.");
	        }
	}
	
	public void verifyHeaderValue(String expectedValue) throws InterruptedException {  
		 // Extract the text from the header element
	     String headerText = getValueByText(getReimbursementHeader());
	     // Verify the value
	     if (headerText.equals(expectedValue)) {
	         System.out.println("Validation successful: " + headerText);
	     } else {
	         System.out.println("Validation failed. Found: " + headerText);
	     }
	}
	
	
	public By getFrame() {
		return iframe;
	}
	
	public By getChatBotCloseBtn() {
		return chatBotCloseBtn;
	}
}
