package com.Test.QLoyalTest.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

import org.hamcrest.CoreMatchers;

import com.Test.QLoyalTest.pages.DemoBookingPage;


public class EndUserSteps {

    DemoBookingPage dictionaryPage;

    @Step
    public void enters(String keyword) {
        //dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void CaptureLoginDetails() {
       // dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
     //   assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page(String URL) {
        dictionaryPage.openAt(URL);
    }

    @Step
    public void looks_for(String Section) {
    	dictionaryPage.CaptureLoginDetails(Section);
        dictionaryPage.ClicksOn(Section);
        //starts_search();
    }
    
    @Step
    public void loginUsingCapturedCredentials() {
    	dictionaryPage.Login();
    	//starts_search();
    }
    
    @Step
    public void ValidateLoginSuccssful() {
    	
    	assertThat(dictionaryPage.Login(),CoreMatchers.containsString("Dashboard")); 
    	//starts_search();
    	
    }
    
    @Step
    public void IfLoginSuccessfulOpenBookingsTab() {
    	
    dictionaryPage.OpenBookings();
    	
    }
    
    @Step
    public void UpdateBookingStatustoGivenStatus(String statusValue) {
    	
    dictionaryPage.UpdateStatustoGivenStatus(statusValue);
    	
    }
    
    @Step
    public void ValidateAllBookingAreInStatus(String statusValue) {
    	
    dictionaryPage.StatusValidate(statusValue);
    	
    }
    
    @Step
    public void Logout() {
    	
    dictionaryPage.LogoutAction();
    	
    }
}