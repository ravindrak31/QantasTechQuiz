package com.Test.QLoyalTest.pages;

import net.thucydides.core.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

//@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary")
public class DemoBookingPage extends PageObject {
	static String userName;
	static String passWord;
	
    @FindBy(xpath="//a[contains(@href,'admin')]")
    private WebElementFacade AdminLink;

    @FindBy(xpath="//a[contains(@href,'admin')]/..")
    private WebElementFacade AdminSection;

    @FindBy(name="email")
    private WebElementFacade loginEmail;
    
    @FindBy(xpath="//button[@type='submit' and div=' Bookings']")
    private WebElementFacade Bookingsbtn;
    
    @FindBy(name="password")
    private WebElementFacade loginPassword;
    
    @FindBy(name="status")
    private WebElementFacade bookingstatuscmb;
    
    @FindBy(xpath="//input[@value='Update Booking']")
    private WebElementFacade UpdateBookingbtn;
    
    @FindBy(linkText=" Log Out")
    private WebElementFacade Logout;
    
    
    public void ClicksOn(String keyword) {
       getDriver().get(AdminLink.getText());
        
    }
    
    
    
    public String Login() {
        loginEmail.type(userName);
        loginPassword.type(passWord+Keys.ENTER);
        return getTitle();
    }

    public void OpenBookings() {
       Bookingsbtn.click();
    }

    public void CaptureLoginDetails(String keyword) {
    	String str=getDriver().findElement(By.cssSelector("div:nth-child(2) > div > div > div.col-md-9 > div.col-md-12 > div > div:nth-child(3) > div.col-md-8 > div")).getText();
        
        String[] splited = str.split("\\s+");
        //This can be better handled, this is just to get code running for tech quiz.
        userName=splited[1];
        passWord=splited[3];
        System.out.println(userName);
        System.out.println(passWord);
    }

   

    public void UpdateStatustoGivenStatus(String statusvalue) {
    	List<WebElementFacade> bookingstatus = findAll(By.xpath("//table[contains(@class,'xcrud-list table table-striped table-hover')]/tbody/tr"));
        
      //  List<WebElement> bookingstatus = bookingtable.findElements(By.xpath(".//tr"));
        
        for(WebElement booking : bookingstatus) {
        	 getDriver().navigate().refresh();
       
        
        WebElement status = booking.findElement(By.xpath(".//td[11]/span"));
       
        WebElement Editbtn=booking.findElement(By.xpath(".//td[12]/span/a[2]"));
        System.out.println("Status: " + status.getText()+" statusvalue: "+statusvalue);
        if(status.getText()!=statusvalue){
        	 
        	 Editbtn.click();
        	updateStatusValue(statusvalue);
        	
        }
     }
    
   }
 
   
    
    public void StatusValidate(String statusValue){
    	WebElement bookingtable = find(By.xpath("//table[contains(@class,'xcrud-list table table-striped table-hover')]/tbody"));
        
        List<WebElement> bookingstatus = bookingtable.findElements(By.xpath(".//tr"));
    	 for(WebElement booking : bookingstatus) {

    		 WebElement status = booking.findElement(By.xpath(".//td[11]/span"));
    	 	if(status.getText()!=statusValue){
    		 Assert.fail();
    	 	}
    	 }
    }
    
    public void updateStatusValue(String statusvalue){
    	bookingstatuscmb.selectByVisibleText(statusvalue);
    	UpdateBookingbtn.click();
    	 getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
    }
    
    public void LogoutAction(){
    	Logout.click();

    }
    
    public void SwitchTabs(){
    	getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);

    }
}