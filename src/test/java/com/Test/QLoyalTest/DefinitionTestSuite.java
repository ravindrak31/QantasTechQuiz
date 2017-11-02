package com.Test.QLoyalTest;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/Update_Booking/UpdateBookingStatusToPaid.feature")
public class DefinitionTestSuite {}
