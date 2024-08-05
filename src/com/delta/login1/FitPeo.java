package com.delta.login1;
import com.delta.login1.PageObjectManager;
import com.delta.login1.FitPeoPage;

public class FitPeo extends Utility {
	public static void main(String[] args) throws InterruptedException {
	PageObjectManager manager;
	FitPeoPage fitPeoPage ;
	
	//Configure the driver
	getDriver();
    
	//To get specific url
	getUrl("https://www.fitpeo.com/");
	
	// Creating page object after Loading Page 
	manager = new PageObjectManager();
    fitPeoPage = manager.getFitPeoPage();
			
	// Navigate to the Revenue Calculator Page
    fitPeoPage.getrevenueCalculatorLink();
    btnClick(fitPeoPage.getrevenueCalculatorLink());
    
    // Wait for the page to load
    explicittWaitUrlContains(10,"revenue-calculator");
    
    // Scroll Down to the Slider section
    scrollDownElem(fitPeoPage.getSliderSection());
    
    // Closing the chatBot message
    explicittWaitUrlPresenceElem(10,fitPeoPage.getFrame());
    switchToFrame(fitPeoPage.getFrame1());
    explicittWaitUrlPresenceElem(10,fitPeoPage.getChatBotCloseBtn());
    btnClick(fitPeoPage.getChatBotCloseBtn1());
    switchToDefaultContent();
    
    // Adjust the Slider to set its value to 820
    fitPeoPage.adjustSlider();
    
    // Verify the bottom text field value
    fitPeoPage.verifyTextField("820");

    // Clear the text field and enter the desired value
    clearTextField(fitPeoPage.getTextField());
    type(fitPeoPage.getTextField(),"560");
    implicitWait(200);

    // verify that the slider's value has been updated
    fitPeoPage.verifySlider("560");

     // Scroll Down to the CPT Codes section
     scrollDown(450);
    
     selectCheckbox(fitPeoPage.getCpt99091());
     selectCheckbox(fitPeoPage.getCpt99453());
     selectCheckbox(fitPeoPage.getCpt99454());
     selectCheckbox(fitPeoPage.getCpt99474());
     
     // Verify that the checkboxes are selected
     fitPeoPage.verifyCheckboxSelected();

     // Clear the text field and enter the desired value 820 to validate the header text value
     clearTextField(fitPeoPage.getTextField());
     type(fitPeoPage.getTextField(),"820");
     implicitWait(200);
     
     //verifying Total Recurring Reimbursement
     fitPeoPage.verifyHeaderValue("$110700");

	
     // Closing Browser
     closeBrowser();
		
}

}
