package com.Test.QLoyalTest.steps;

import net.thucydides.core.annotations.Steps;

import com.Test.QLoyalTest.steps.serenity.EndUserSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class DefinitionSteps {

    @Steps
    EndUserSteps UserSteps;

  
    @Given("the user is on the '(.*)' page")
    public void givenUserisOnHomePage(String URL){
    	UserSteps.is_the_home_page(URL);
    }
   
    @When("user clicks on link provided in '(.*)' Section And Login using credentials provided")
    public void WhenUserClicksOnProvidedLink(String Section){
    	UserSteps.looks_for(Section);
    	UserSteps.loginUsingCapturedCredentials();
    }
    
    @When("user is on main landing page")
    public void WhenUserChecksLoginSuccessful(){
    	
    }
    
    @Then("user clicks 'Bookings' button to view listing")
    public void ThenUserClicksonBookings(){
    	UserSteps.IfLoginSuccessfulOpenBookingsTab();
    }
    
    @Then("user updates listing status to '(.*)' if not 'Paid' already")
    public void ThenUserUpdatedListingToPaid(String statusValue){
    	UserSteps.UpdateBookingStatustoGivenStatus(statusValue);
    }
    
    @Then("user ensure all listings have '(.*)' status")
    public void ThenUserEnsureListingUpdatedTOPaid(String statusValue){
    	
    }
    
    @Then("user logs out") 
    public void ThenUserLogsOut(){
    	
    }
}
